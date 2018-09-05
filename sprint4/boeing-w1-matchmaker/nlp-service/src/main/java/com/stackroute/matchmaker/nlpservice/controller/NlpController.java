package com.stackroute.matchmaker.nlpservice.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stackroute.matchmaker.nlpservice.model.Search;
import com.stackroute.matchmaker.nlpservice.nlpprocess.Tagging;
import com.stackroute.matchmaker.nlpservice.nlpprocess.Tokenization;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class NlpController {

	public Tokenization tokenization = new Tokenization();
	List<String> tokenString = new ArrayList<>();
	Scanner s;
	Tagging tagging = new Tagging();
	Search search = new Search();
	RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/search/{search}")
	public ResponseEntity<?> breakString(@PathVariable("search") String string) throws FileNotFoundException {
		System.out.println(string);
		s = new Scanner(new File("stopword.txt"));
		ArrayList<String> stopword = new ArrayList<String>();
		while (s.hasNext()) {
			stopword.add(s.next().toLowerCase());
		}

		s = new Scanner(new File("extra.txt"));
		ArrayList<String> extra = new ArrayList<String>();
		while (s.hasNext()) {
			extra.add(s.next().toLowerCase());
		}

		s = new Scanner(new File("skill.txt"));
		ArrayList<String> skill = new ArrayList<String>();
		while (s.hasNext()) {
			skill.add(s.next().toLowerCase());
		}

		s = new Scanner(new File("organisation.txt"));
		ArrayList<String> organisation = new ArrayList<String>();
		while (s.hasNext()) {
			organisation.add(s.next().toLowerCase());
		}

		s = new Scanner(new File("location.txt"));
		ArrayList<String> location = new ArrayList<String>();
		while (s.hasNext()) {
			location.add(s.next().toLowerCase());
		}

		tokenString = tokenization.token(string, stopword, extra, skill);
		search.setSkill(tagging.taggingFunc(tokenString, skill));
		search.setLocation(tagging.taggingFunc(tokenString, location));
		search.setOrganisation(tagging.taggingFunc(tokenString, organisation));
		search.setYears(tagging.taggingYears(tokenString, extra));

		System.out.println(search);

		String url = "http://localhost:8998/searchengine";
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Search> entity = new HttpEntity<>(search, headers);

		return restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	}
}