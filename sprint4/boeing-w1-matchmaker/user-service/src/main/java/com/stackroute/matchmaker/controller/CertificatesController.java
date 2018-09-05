package com.stackroute.matchmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.matchmaker.model.Certificates;

@CrossOrigin("*") 
@RequestMapping("/api/v1/certificates")
@RestController
public class CertificatesController {
	
	@Autowired
    private KafkaTemplate<String, Certificates> kafkaTemplate;

	@Value("${app.certificates.name}")
    private String topic;

    @PostMapping("/publish")
    public String post(@RequestBody Certificates certificates) {

        kafkaTemplate.send(topic , certificates);

        return "Published successfully";
    }

}
