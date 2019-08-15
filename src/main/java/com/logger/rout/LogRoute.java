package com.logger.rout;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.logger.rout.service.CsvToModelMapper;
import com.logger.rout.service.PersistService;

import org.apache.camel.LoggingLevel;


@Component
public class LogRoute extends RouteBuilder {
	private static final long BATCH_TIME_OUT = 3000L;

	private static final int MAX_RECORDS = 900;
	
	//@Value("${log.file.input}")
	//private String folderPath;
	
	//@Value("${log.file.output}")
	//private String folderPathout;
	
	@Autowired
	private CsvToModelMapper csvToModelConverter;
	
	@Autowired
	@Qualifier("mysqlPersistService")
	private PersistService persistService;

	@Override
	public void configure() throws Exception {


  // The location of the file is in /deployments so if you put file://tmp in the container it is /deployments/tmp
  // This assumes the ais files are top level in the bucket and uncompressed with no headers
  // This setup requires that when the kafka cluster is made it has an internal route available without TLS
  /*
    from("aws-s3://demojam?accessKey=RAW()&secretKey=RAW()&deleteAfterRead=false&maxMessagesPerPoll=2&delay=1000")
        .routeId("define-file-name")
        .autoStartup("{{S3toKafkastartupRouteProperty}}")
        .setHeader("myHeader", constant("${in.header.CamelAwsS3Key}"))
        .log(LoggingLevel.INFO, "consuming", "Consumer Fired!")
        .log(LoggingLevel.INFO, "Replay Message Sent to file:s3out ${in.header.CamelAwsS3Key}")
        .to("kafka:ais-cluster-kafka-bootstrap.amq-streams.svc.cluster.local:9092?topic=ais-topic&brokers=ais-cluster-kafka-bootstrap.amq-streams.svc.cluster.local:9092");
*/

                from("aws-s3://demojam?accessKey=RAW()&secretKey=RAW()&deleteAfterRead=false&maxMessagesPerPoll=2&delay=1000")
		.log(LoggingLevel.INFO, " Start Processing: file:s3out ${in.header.CamelAwsS3Key} ....")
		.multicast()
		.parallelProcessing()
                .to("direct:gunzip")
		.end();

                from("direct:gunzip")
                   .unmarshal().gzip()
                   .to("direct:database-save")
                   .end();

		from("direct:database-save")
                   .log(LoggingLevel.INFO, "Start saving to database ....")
                   .split()
                   .tokenize("\n")
                   .streaming()
                   .unmarshal()
                   .bindy(BindyType.Csv, CSVRecord.class)
                   .bean(csvToModelConverter, "convertToMysqlModel")
                   .aggregate(constant(true), batchAggregationStrategy())
                   .completionPredicate(batchSizePredicate())
                   .completionTimeout(BATCH_TIME_OUT)
                   .bean(persistService)
                   .log(LoggingLevel.INFO, "End saving to database ....")
                   .end();

	}

	@Bean
	private AggregationStrategy batchAggregationStrategy() {
		return new ArrayListAggregationStrategy();
	}

	@Bean
	public Predicate batchSizePredicate() {
		return new BatchSizePredicate(MAX_RECORDS);
	}

}
