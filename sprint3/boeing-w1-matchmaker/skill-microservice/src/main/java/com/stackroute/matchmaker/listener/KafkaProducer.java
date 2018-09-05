package com.stackroute.matchmaker.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.matchmaker.model.Skills;

@RestController
@RequestMapping("kafka")
public class KafkaProducer {

	// using template defined in configuration class

	@Autowired
	private KafkaTemplate<String, Skills> kafkaTemplateskill;

	// private ProcessedSkill processed_skill;
	@Value("${listener.topic.name}")
	private String TOPIC;

	// @GetMapping("/publishIndexer/{id}")
	// public String post(@PathVariable("id") final String id) {
	//
	// // publishing to kafka
	// kafkaTemplate.send(topic, new ProcessedSkill(id, "Java", "moderate"));
	//
	// return "Published successfully";
	// }

	@GetMapping("/publish/{name}")
	public String postskill(@PathVariable("name") final String name) {

		// publishing to kafka
		kafkaTemplateskill.send(TOPIC, new Skills(name, name, name, name, name, name));

		return "Published successfully";
	}
}