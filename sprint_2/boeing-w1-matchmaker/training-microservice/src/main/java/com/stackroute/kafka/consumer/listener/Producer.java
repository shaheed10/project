package com.stackroute.kafka.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.kafka.consumer.model.Training;

@RestController
@RequestMapping("kafka")
public class Producer {
	
	@Autowired
	private KafkaTemplate<String,Training> kafkaTemplate;
	
	@Value("${listener.topic.name}")
	private String TOPIC ;
	
	private String topic = "sathwik";
	
	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String name) {
		kafkaTemplate.send(TOPIC, new Training(name,name,name,name,name,name,name));
		kafkaTemplate.send(topic, new Training(name,name,name,name,name,name,name));

		return "published";
	}
}
