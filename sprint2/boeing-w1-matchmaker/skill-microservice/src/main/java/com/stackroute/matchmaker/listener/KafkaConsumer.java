package com.stackroute.matchmaker.listener;

// Organize Import ctrl+shift+O
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

	/*
	 * @KafkaListener- Annotation that marks a method to be the target of a Kafka
	 * message listener on the specified topics
	 */

	// kafka string or default listener

	@KafkaListener(topics = "Location_String", groupId = "group_id")
	public void consume(String message) {
		LOG.info("Consumed message='{}'", message);
	}

	// kafka json listener, specifying the listener container factory
	// @KafkaListener(topics = "${listener.topic.name}", group = "group_json",
	// containerFactory = "skillKafkaListenerFactory")
	// public void consumeJson(Skill skill) {
	// LOG.info("Consumed JSON message='{}'", skill);
	// }

}
