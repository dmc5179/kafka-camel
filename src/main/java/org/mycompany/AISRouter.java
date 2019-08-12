package org.mycompany;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;


import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.component.kafka.KafkaComponent;
//import org.apache.camel.component.kafka.KafkaConstants;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;

import java.io.File;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import org.apache.camel.LoggingLevel;
//import org.apache.camel.support.processor.idempotent.FileIdempotentRepository;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

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

import java.net.URL;

@Component
public class AISRouter extends RouteBuilder {
    
  //private final static Logger log = LoggerFactory.getLogger(RestConfiguration.class);
   private static final long BATCH_TIME_OUT = 3000L;

   private static final int MAX_RECORDS = 900;
	
  //The properties bean autoconfigured by application properties
  @Autowired
  ServerProperties serverProperties;

 @Autowired
 private CsvToModelMapper csvToModelConverter;

  @Autowired
  private PersistService persistService;

/*
    @Override
    protected int poll() throws Exception {
        // must reset for each poll
        shutdownRunningTask = null;
        pendingExchanges = 0;
        
        String bucketName = "mapd-data";
        LOG.trace("Quering objects in bucket [{}]...", bucketName);
        
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        listObjectsRequest.setBucketName(bucketName);
        listObjectsRequest.setMaxKeys(getMaxMessagesPerPoll());
        
        ObjectListing listObjects = getAmazonS3Client().listObjects(listObjectsRequest);
        
        LOG.trace("Found {} objects in bucket [{}]...", listObjects.getObjectSummaries().size(), bucketName);
        
        Queue<Exchange> exchanges = createExchanges(listObjects.getObjectSummaries());
        return processBatch(CastUtils.cast(exchanges));
    }
*/
    
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

/*
    StringBuffer aisInsert = new StringBuffer("INSERT INTO ships_ais(Longitude ,Latitude ,unused_z ,SOG ,COG ,Heading ,ROT ,BaseDateTime ,Status ,VoyageID");
      aisInsert.append(" ,MMSI ,ReceiverType ,ReceiverID ,Destination ,Cargo ,Draught ,ETA ,StartTime ,EndTime ,unused_IMO ,unused_CallSign ,unused_Name");
      aisInsert.append(" ,VesselType ,VesselLength ,VesselWidth ,DimensionComponents) ");
      aisInsert.append("VALUES (:#Longitude ,:#Latitude ,:#unused_z ,:#SOG ,:#COG ,:#Heading ,:#ROT ,:#BaseDateTime ,:#Status ,:#VoyageID");
      aisInsert.append(", :#MMSI ,:#ReceiverType ,:#ReceiverID ,:#Destination ,:#Cargo ,:#Draught ,:#ETA ,:#StartTime ,:#EndTime ,:#unused_IMO ,:#unused_CallSign ,:#unused_Name");
      aisInsert.append(",:#VesselType ,:#VesselLength ,:#VesselWidth ,:#DimensionComponents");
      aisInsert.append(")");
*/
/*
CsvDataFormat csv = new CsvDataFormat();
CSVStrategy strategy = CSVStrategy.DEFAULT_STRATEGY;
strategy.setDelimiter('|');
csv.setStrategy(strategy);
*/

    from("aws-s3://demojam?accessKey=RAW()&secretKey=RAW()&deleteAfterRead=false&maxMessagesPerPoll=2&delay=1000")
        .routeId("S3-to-postgis")
        .autoStartup("True")
        .log(LoggingLevel.INFO, "Sending file to postgis file:s3out ${in.header.CamelAwsS3Key}")
        .split()
        .tokenize("\n")
        .streaming()
//        .filter(simple("${body.length} &gt; 30"))
        .unmarshal()
        .bindy(org.apache.camel.model.dataformat.BindyType.Csv, AISCSVRecord.class)
        .bean(csvToModelConverter, "convertToPostgisModel")
        .aggregate(constant(true), batchAggregationStrategy())
        .completionPredicate(batchSizePredicate())
        .completionTimeout(BATCH_TIME_OUT)
        .bean(persistService)
        .end();



//  .to("bean:myCsvHandler?method=doHandleCsv");
//        .split().tokenize("\n", 1).to("sql:"+aisInsert.toString()+"?dataSource=postgisDataSource");
//        .split().tokenize("\n", 1000).streaming().to("postgisSQLComponent:"+aisInsert.toString());


/*
    from("kafka:ais-cluster-kafka-bootstrap.amq-streams.svc.cluster.local:9092?topic=ais-topic&brokers=ais-cluster-kafka-bootstrap.amq-streams.svc.cluster.local:9092")
        .routeId("kafka-to-omniscidb")
        .log("Inserted new AIS point").beanRef("aisMapper", "getMap")
        .to("sqlComponent:{{sql.insertAIS}}");
*/
//        .autoStartup("{{kafkaToSQLstartupRouteProperty}}")
//


//        .to("direct:insert");

//    from("direct:insert").log("Inserting AIS Row").beanRef("AISMapper", "getMap")
//            .to("sqlComponent:{{sql.insertAis}}");

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
