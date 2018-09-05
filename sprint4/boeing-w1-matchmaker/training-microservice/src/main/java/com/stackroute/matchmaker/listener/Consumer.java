package com.stackroute.matchmaker.listener;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.matchmaker.model.Certificates;

@Service
public class Consumer {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

	//KafkaTemplate<String, String> kt;


	//	//Listens to the topic "training" of kafka
	//	@KafkaListener(topics = "training")
	//	public void consumeJson(Training training) {
	//		//System.out.println("Consumed JSON Message: " + training);
	//		LOG.info("consumed message='{}'", training);
	//	}

	//Listens to the topic "Certificates" of upstream
	@KafkaListener(topics = "${app.topic.training}",groupId = "group_json", containerFactory = "userKafkaListenerFactory")
	public void receiveJson(Certificates certificates) {
		//System.out.println("Consumed JSON Message: " + training);
		LOG.info("consumed message='{}'", certificates);
	}

}
