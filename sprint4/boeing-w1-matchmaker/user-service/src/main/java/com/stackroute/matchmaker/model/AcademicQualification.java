package com.stackroute.matchmaker.model;

public class AcademicQualification {

	private String profileId;
	private String qualification;
	private String instituteName;
	private String yearOfJoining;
	private String yearOfCompletion;
	private String stream;
	private String marks;
	private String message;
	
	public AcademicQualification() {
	}

	public AcademicQualification(String profileId, String qualification, String instituteName, String yearOfJoining,
			String yearOfCompletion, String stream, String marks, String message) {
		super();
		this.profileId = profileId;
		this.qualification = qualification;
		this.instituteName = instituteName;
		this.yearOfJoining = yearOfJoining;
		this.yearOfCompletion = yearOfCompletion;
		this.stream = stream;
		this.marks = marks;
		this.message = message;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(String yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public String getYearOfCompletion() {
		return yearOfCompletion;
	}

	public void setYearOfCompletion(String yearOfCompletion) {
		this.yearOfCompletion = yearOfCompletion;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String streams) {
		this.stream = streams;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AcademicQualification [profileId=" + profileId + ", qualification=" + qualification + ", instituteName="
				+ instituteName + ", yearOfJoining=" + yearOfJoining + ", yearOfCompletion=" + yearOfCompletion
				+ ", streams=" + stream + ", marks=" + marks + ", message=" + message + "]";
	}

	
    
	
	
}
