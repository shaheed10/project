package com.stackroute.matchmaker.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.matchmaker.model.AcademicQualification;
import com.stackroute.matchmaker.producer.Receiver;

@Service
public class KafkaConsumer {
	
	 private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);
	/* Annotating a method with @KafkaListener makes it listen to the topic , group mentioned .
	 Then it consumes messages and executes the consumeJson function*/
	 
	
	 @Autowired
		private Receiver receiver;
     
    @KafkaListener(topics = "${app.topic.name}",
            containerFactory = "qualificationKafkaListenerFactory")
    public void consumeJson(AcademicQualification qualification) {
    	  LOG.info("received message in consumer ='{}'", qualification);
    	  receiver.consumeJson(qualification);
    	  
    }
}