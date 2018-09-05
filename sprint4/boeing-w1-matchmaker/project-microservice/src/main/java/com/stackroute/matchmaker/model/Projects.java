package com.stackroute.matchmaker.model;

public class Projects {

	private String profileId;
	private String projectId;
	private String projectAt;
	private String role;
	private String department;
	private String projectLocation;
	private String projectTitle;
	private String from;
	private String to;
	private String synopsis;
	private String url;
	private String demoURL;
	private String skills;
	private String message;

	// Default Constructor
	public Projects() {

	}

	public Projects(String profileId, String projectId, String projectAt, String role, String department,
			String projectLocation, String projectTitle, String from, String to, String synopsis, String url,
			String demoURL, String skills, String message) {
		super();
		this.profileId = profileId;
		this.projectId = projectId;
		this.projectAt = projectAt;
		this.role = role;
		this.department = department;
		this.projectLocation = projectLocation;
		this.projectTitle = projectTitle;
		this.from = from;
		this.to = to;
		this.synopsis = synopsis;
		this.url = url;
		this.demoURL = demoURL;
		this.skills = skills;
		this.message = message;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectAt() {
		return projectAt;
	}

	public void setProjectAt(String projectAt) {
		this.projectAt = projectAt;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProjectLocation() {
		return projectLocation;
	}

	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDemoURL() {
		return demoURL;
	}

	public void setDemoURL(String demoURL) {
		this.demoURL = demoURL;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Projects [profileId=" + profileId + ", projectId=" + projectId + ", projectAt=" + projectAt + ", role="
				+ role + ", department=" + department + ", projectLocation=" + projectLocation + ", projectTitle="
				+ projectTitle + ", from=" + from + ", to=" + to + ", synopsis=" + synopsis + ", url=" + url
				+ ", demoURL=" + demoURL + ", skills=" + skills + ", message=" + message + "]";
	}

}
