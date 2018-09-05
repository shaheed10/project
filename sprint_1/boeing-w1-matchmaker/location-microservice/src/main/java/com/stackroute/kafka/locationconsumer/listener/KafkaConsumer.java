package com.stackroute.kafka.locationconsumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.kafka.locationconsumer.model.Location;

@Service
public class KafkaConsumer {

       private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);    
	
            
	/* @KafkaListener- Annotation that marks a method to be the target of a 
		Kafka message listener on the specified topics  */
	
	    //kafka string or default listener
	    @KafkaListener(topics = "Location_String")
	    public void consume(String message) {
	     LOG.info("Consumed message='{}'", message);
	    }
	
	    //kafka json listener, specifying the listener container factory group = "group_json"
	    @KafkaListener(topics = "${consumer.location.topic}", containerFactory = "locationKafkaListenerFactory")
	    public void consumeJson(Location location) {
         LOG.info("Consumed JSON message='{}'", location);
	    }
    
    }
