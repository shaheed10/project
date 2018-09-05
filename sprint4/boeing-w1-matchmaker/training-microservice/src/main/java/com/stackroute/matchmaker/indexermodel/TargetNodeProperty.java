package com.stackroute.matchmaker.indexermodel;

public class TargetNodeProperty {

	private String id;

	public TargetNodeProperty() {
	}

	/**
	 * @param id
	 */
	public TargetNodeProperty(String id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TargetNodeProperty [id=" + id + "]";
	}
}
