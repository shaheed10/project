package com.stackroute.matchmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.matchmaker.model.AcademicQualification;

@CrossOrigin("*")
@RequestMapping("/api/v1/qualification")
@RestController
public class AcademicQualificationController {
	
	@Autowired
    private KafkaTemplate<String, AcademicQualification> kafkaTemplate;

    private static final String TOPIC = "Academies";

    @PostMapping("/publish")
    public String post(@RequestBody AcademicQualification academy) {

        kafkaTemplate.send(TOPIC , academy);

        return "Published successfully";
    }
	
}
