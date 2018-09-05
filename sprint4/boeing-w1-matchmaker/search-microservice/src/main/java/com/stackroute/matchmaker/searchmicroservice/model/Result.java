package com.stackroute.matchmaker.searchmicroservice.model;

import java.util.List;

import org.springframework.data.neo4j.annotation.QueryResult;

import lombok.Data;
/**
 * 
 * @author simran
 *
 */
@QueryResult
@Data
public class Result {
	private String profileId;
	private List<String> skills;
	private String experience;
	private String city;

}
