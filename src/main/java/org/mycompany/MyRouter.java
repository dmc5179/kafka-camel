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
import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.component.kafka.KafkaConstants;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;

import java.io.File;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSCredentialsProvider;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import org.apache.camel.LoggingLevel;
//import org.apache.camel.support.processor.idempotent.FileIdempotentRepository;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Component
public class MyRouter extends RouteBuilder {
    
  //private final static Logger log = LoggerFactory.getLogger(RestConfiguration.class);
	
  //The properties bean autoconfigured by application properties
  @Autowired
  ServerProperties serverProperties;
    
  @Override
  public void configure() throws Exception {
                

     PropertiesComponent pc = getContext().getComponent("properties", PropertiesComponent.class);
     pc.setLocation("classpath:application.properties");

     String topicName = "topic=ais-topic";
     String kafkaServer = "kafka:localhost:9092";
     String zooKeeperHost = "zookeeperHost=localhost&zookeeperPort=2181";
     String serializerClass = "serializerClass=kafka.serializer.StringEncoder";

     String toKafka = new StringBuilder().append(kafkaServer).append("?").append(topicName).append("&")
          .append(zooKeeperHost).append("&").append(serializerClass).toString();


/*
 from("aws-s3://mapd-data/ships-ais/2014/?deleteAfterRead=false&maxMessagesPerPoll=25&delay=5000")
            .log(LoggingLevel.INFO, "consuming", "Consumer Fired!")
            .idempotentConsumer(header("CamelAwsS3ETag"),
                    FileIdempotentRepository.fileIdempotentRepository(new File("target/file.data"), 250, 512000))
            .log(LoggingLevel.INFO, "Replay Message Sent to file:s3out ${in.header.CamelAwsS3Key}")
                .to("file:target/s3out?fileName=${in.header.CamelAwsS3Key}");
*/

     // Read from file and send to Kafka
     //from("file:///inbox?noop=true").split().tokenize("\n").to(toKafka);

     // Maybe read from S3 instead
     //from("aws-s3://MyBucket?amazonS3Client=#client&delay=5000&maxMessagesPerPoll=5")
     //from("aws-s3://bucket-name?deleteAfterRead=false&maxMessagesPerPoll=25&delay=5000")

/*
     // setup kafka component with the brokers
     KafkaComponent kafka = new KafkaComponent();
     kafka.setBrokers("{{kafka.host}}:{{kafka.port}}");

     from("direct:kafkaStart").routeId("DirectToKafka")
       .to("kafka:{{producer.topic}}").log("${headers}");

     // Topic can be set in header as well.

     from("direct:kafkaStartNoTopic").routeId("kafkaStartNoTopic")
       .to("kafka:dummy")
       .log("${headers}");

     // Use custom partitioner based on the key.

     from("direct:kafkaStartWithPartitioner").routeId("kafkaStartWithPartitioner")
       .to("kafka:{{producer.topic}}?partitioner={{producer.partitioner}}")
       .log("${headers}");


     // Takes input from the command line.

     from("stream:in").setHeader(KafkaConstants.PARTITION_KEY, simple("0"))
       .setHeader(KafkaConstants.KEY, simple("1")).to("direct:kafkaStart");
*/     
      
  }
/*
  @Produces
  @Named("amazonS3Client")
  AmazonS3 amazonS3Client() {
    AWSCredentials credentials = new BasicAWSCredentials("AKIAIOWVV6Q3NZOQUQCQ", "6wf28vlUUAFUthfdAcHMicvuA6oTUB+piFcksZXa");
    AWSCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(credentials);
    AmazonS3ClientBuilder clientBuilder = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).withCredentials(credentialsProvider);
    return clientBuilder.build();
  }
  */ 
}
