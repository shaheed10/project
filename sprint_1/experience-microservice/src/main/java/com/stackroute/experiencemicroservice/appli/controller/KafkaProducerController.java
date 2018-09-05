package com.stackroute.experiencemicroservice.appli.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.experiencemicroservice.appli.indexermodel.Indexer;
import com.stackroute.experiencemicroservice.appli.indexermodel.RelationshipName;
import com.stackroute.experiencemicroservice.appli.indexermodel.RelationshipProperties;
import com.stackroute.experiencemicroservice.appli.indexermodel.TargetNodeProperty;
import com.stackroute.experiencemicroservice.appli.model.Experience;

@RestController
@RequestMapping("kafka")
public class KafkaProducerController {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaProducerController.class);
	public TargetNodeProperty targetNodeProperty = new TargetNodeProperty();
	public RelationshipName relationshipName = new RelationshipName();
	public RelationshipProperties relationshipProperties = new RelationshipProperties();
	public Indexer wasRelationIndexer = new Indexer();
	public Indexer isRelationIndexer = new Indexer();

	 @Autowired
	 private KafkaTemplate<String, Indexer> kafkaTemplate;
	 @Value("${experienceproducer.producer.exp}")
	private String TOPIC;

	public void produceJson(Experience experience) {

		// Target Node Type
//		wasRelationIndexer.setTargetNodeType("Profile");
		//isRelationIndexer.setTargetNodeProperty("Profile");
		
		
		//Source Node Type
//		wasRelationIndexer.setSourceNodeProperty("Experience");
//		isRelationIndexer.setSourceNodeProperty("Experience");
		
		//Source Node Property
//		wasRelationIndexer.setSourceNodeProperty(experience.getProfileId());
//		isRelationIndexer.setSourceNodeProperty(experience.getProfileId());
		
		//Target Node Property
//		targetNodeProperty.setProfileId(experience.getProfileId());
//		
//		wasRelationIndexer.setTargetNodeProperty(targetNodeProperty);
//		isRelationIndexer.setTargetNodeProperty(targetNodeProperty);
		
		
		//RelationShip properties
//		relationshipProperties.setOrganizationName(experience.getOrganizationName());
//		relationshipProperties.setRole(experience.getRole());
//		relationshipProperties.setStartDate(experience.getStartDate());
//		relationshipProperties.setEndDate(experience.getEndDate());
		
//		RelationshipName relation = new RelationshipName(relationshipProperties); 
//		wasRelationIndexer.setRelationshipName(relation);
		
	//Indexer indexer = new Indexer(sourceNodeType,sourceNodeProperty,targetNodeType,targetNodeProperty,relationshipProperties,relationshipName);
    Indexer indexer = new Indexer("Experience","sourceNodeProperty","jsbdcvb",targetNodeProperty,
			 relationshipProperties,relationshipName,"Created" );
    	kafkaTemplate.send(TOPIC,indexer);
    	LOG.info("sending JSON message='{}'",indexer,TOPIC);

		// @GetMapping("/publish/{profileId}")
		// public String post(@PathVariable("profileId") final String profileId) {
		// LOG.info("sending JSON message='{}' to topic='{}'", profileId, TOPIC);
		//
		// kafkaTemplate.send(TOPIC, new Experience(profileId, "Morgan-Stanley",
		// "Software-Developer", "04/09/2012",
		// "03/08/2017", "Successful"));
		//
		// return "Sent JSON message successfully";
		// }
	}
}
