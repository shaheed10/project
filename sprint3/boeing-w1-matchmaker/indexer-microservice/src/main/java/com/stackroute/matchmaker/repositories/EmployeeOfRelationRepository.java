package com.stackroute.matchmaker.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.stackroute.matchmaker.relationships.EmployeeOfRelation;
/**
 * 
 * @author syam
 *
 */
public interface EmployeeOfRelationRepository extends Neo4jRepository<EmployeeOfRelation, String>{

}