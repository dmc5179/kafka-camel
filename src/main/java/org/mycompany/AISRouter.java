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

import java.net.URL;

@Component
public class AISRouter extends RouteBuilder {
    
  //private final static Logger log = LoggerFactory.getLogger(RestConfiguration.class);
	
  //The properties bean autoconfigured by application properties
  @Autowired
  ServerProperties serverProperties;
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
/*                
     PropertiesComponent pc = getContext().getComponent("properties", PropertiesComponent.class);
     pc.setLocation("classpath:application.properties");
*/

    //String filePath= Thread.currentThread().getContextClassLoader().getResource("keystore.pfx").getFile();
    //System.setProperty("javax.net.ssl.trustStore", filePath);
    //System.setProperty("javax.net.ssl.trustStorePassword", "password");

//    URL trustStoreResource = MyRouter.class.getResource( "/keystore.jks" );
//        String path = trustStoreResource.toURI().getPath();
//        System.setProperty("javax.net.ssl.trustStore", path);
//        System.setProperty("javax.net.ssl.trustStorePassword", "password");

// The location of the file is in /deployments so if you put file://tmp in the container it is /deployments/tmp
    from("aws-s3://demojam?accessKey=RAW()&secretKey=RAW()&deleteAfterRead=false&maxMessagesPerPoll=2&delay=1000")
        .routeId("define-file-name")
        .setHeader("myHeader", constant("${in.header.CamelAwsS3Key}"))
        .log(LoggingLevel.INFO, "consuming", "Consumer Fired!")
        .log(LoggingLevel.INFO, "Replay Message Sent to file:s3out ${in.header.CamelAwsS3Key}")
      .to("kafka:ais-topic?brokers=ais-cluster-kafka-bootstrap-amq-streams.apps.dan.redhatgov.io:443&securityProtocol=SSL");

//        .to("file:/tmp?fileName=${in.header.CamelAwsS3Key}");


//        .to("direct:insert");

//    from("direct:insert").log("Inserting AIS Row").beanRef("AISMapper", "getMap")
//            .to("sqlComponent:{{sql.insertAis}}");

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

}
