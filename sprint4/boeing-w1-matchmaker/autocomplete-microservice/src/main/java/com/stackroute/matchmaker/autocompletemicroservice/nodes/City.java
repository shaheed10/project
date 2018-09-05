package com.stackroute.matchmaker.autocompletemicroservice.nodes;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * 
 * @author syam
 *
 */
// this is the pojo class based on which the nodes and their properties in the
// neo4j are created upon
@NodeEntity
public class City {
	@Id
	private String city;

	public City() {
		super();
	}

	public City(String city) {
		super();
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "City [city=" + city + "]";
	}

}
