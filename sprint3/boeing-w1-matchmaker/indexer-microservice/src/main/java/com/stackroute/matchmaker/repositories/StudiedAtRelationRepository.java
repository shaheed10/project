package com.stackroute.matchmaker.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.stackroute.matchmaker.relationships.StudiedAtRelation;

/**
 * 
 * @author syam
 *
 */
public interface StudiedAtRelationRepository extends Neo4jRepository<StudiedAtRelation, String>{

}
