package com.stackroute.matchmaker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.matchmaker.indexermodel.ExperienceIndex;
import com.stackroute.matchmaker.indexermodel.LocationIndex;
import com.stackroute.matchmaker.indexermodel.ProjectIndex;
import com.stackroute.matchmaker.indexermodel.QualificationIndex;
import com.stackroute.matchmaker.indexermodel.SkillIndex;
import com.stackroute.matchmaker.indexermodel.TrainingIndex;
import com.stackroute.matchmaker.nodes.City;
import com.stackroute.matchmaker.nodes.Company;
import com.stackroute.matchmaker.nodes.ProfileId;
import com.stackroute.matchmaker.nodes.Project;
import com.stackroute.matchmaker.nodes.Skill;
import com.stackroute.matchmaker.nodes.Training;
import com.stackroute.matchmaker.nodes.University;
import com.stackroute.matchmaker.relationships.EmployeeOfRelation;
import com.stackroute.matchmaker.relationships.HasSkill;
import com.stackroute.matchmaker.relationships.LivedInRelation;
import com.stackroute.matchmaker.relationships.LivesInRelation;
import com.stackroute.matchmaker.relationships.StudiedAtRelation;
import com.stackroute.matchmaker.relationships.TrainingCoversSkill;
import com.stackroute.matchmaker.relationships.TrainingUndergone;
import com.stackroute.matchmaker.relationships.UsesSkillRelation;
import com.stackroute.matchmaker.relationships.WorkedInRelation;
import com.stackroute.matchmaker.repositories.EmployeeOfRelationRepository;
import com.stackroute.matchmaker.repositories.HasSkillRepository;
import com.stackroute.matchmaker.repositories.LivedInRelationRepository;
import com.stackroute.matchmaker.repositories.LivesInRelationRepository;
import com.stackroute.matchmaker.repositories.StudiedAtRelationRepository;
import com.stackroute.matchmaker.repositories.TrainingCoversSkillRepository;
import com.stackroute.matchmaker.repositories.TrainingUndergoneRepository;
import com.stackroute.matchmaker.repositories.UsesSkillRelationRepository;
import com.stackroute.matchmaker.repositories.WorkedInRelationRepository;

@Service
public class KafkaConsumer {
	private HasSkillRepository hasSkillRepository;
	private TrainingUndergoneRepository trainingUndergoneRepository;
	private TrainingCoversSkillRepository trainingCoversSkillRepository;
	private EmployeeOfRelationRepository employeeOfRelationRepository;
	private LivesInRelationRepository livesInRelationRepository;
	private LivedInRelationRepository livedInRelationRepository;
	private WorkedInRelationRepository workedInRelationRepository;
	private UsesSkillRelationRepository usesSkillRelationRepository;
	private StudiedAtRelationRepository studiedAtRelationRepository;

	public KafkaConsumer() {
		super();
	}

	@Autowired
	public KafkaConsumer(HasSkillRepository hasSkillRepository, TrainingUndergoneRepository trainingUndergoneRepository,
			TrainingCoversSkillRepository trainingCoversSkillRepository,
			EmployeeOfRelationRepository employeeOfRelationRepository,
			LivesInRelationRepository livesInRelationRepository, LivedInRelationRepository livedInRelationRepository,
			WorkedInRelationRepository workedInRelationRepository,
			UsesSkillRelationRepository usesSkillRelationRepository,
			StudiedAtRelationRepository studiedAtRelationRepository) {
		super();
		this.hasSkillRepository = hasSkillRepository;
		this.trainingUndergoneRepository = trainingUndergoneRepository;
		this.trainingCoversSkillRepository = trainingCoversSkillRepository;
		this.employeeOfRelationRepository = employeeOfRelationRepository;
		this.livesInRelationRepository = livesInRelationRepository;
		this.livedInRelationRepository = livedInRelationRepository;
		this.workedInRelationRepository = workedInRelationRepository;
		this.usesSkillRelationRepository = usesSkillRelationRepository;
		this.studiedAtRelationRepository = studiedAtRelationRepository;
	}

	@KafkaListener(topics = "String_Boo", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
	public void consume(String message) {
		System.out.println("Consumed message: " + message);
	}

	@KafkaListener(topics = "LocationIndexer", groupId = "group_json", containerFactory = "locationKafkaListenerFactory")
	public void consumeJson(LocationIndex locationIndex) {
		System.out.println("Consumed JSON Message: " + locationIndex);
		ProfileId profileId = new ProfileId(locationIndex.getProfileId());
		City city = new City(locationIndex.getCity());
		if (locationIndex.getAddressType().equals("present")) {
			LivesInRelation livesInRelation = new LivesInRelation(profileId, city);
			livesInRelationRepository.save(livesInRelation);
		} else {
			LivedInRelation livedInRelation = new LivedInRelation(profileId, city);
			livedInRelationRepository.save(livedInRelation);

		}

	}

	@KafkaListener(topics = "SkillIndexer123", groupId = "group_json", containerFactory = "skillKafkaListenerFactory")
	public void consumeJson(SkillIndex skillIndex) {
		System.out.println("Consumed JSON Message: " + skillIndex);
		// cityRepository.findById(locationListner.getCityName());
		// System.out.println(cityRepository.findById(locationListner.getCityName()));
		Skill skill = new Skill(skillIndex.getSkill());
		ProfileId profileId = new ProfileId(skillIndex.getProfileId());
		HasSkill hasSkill = new HasSkill(skillIndex.getWeightage(), profileId, skill);
		// profileIdRepository.save(profileId);
		hasSkillRepository.save(hasSkill);

	}

	@KafkaListener(topics = "TrainingIndexer", groupId = "group_json", containerFactory = "trainingKafkaListenerFactory")
	public void consumeJson(TrainingIndex trainingIndex) {
		System.out.println("Consumed JSON Message: " + trainingIndex);
		// cityRepository.findById(locationListner.getCityName());
		// System.out.println(cityRepository.findById(locationListner.getCityName()));
		Skill skill = new Skill(trainingIndex.getSkills());
		Training training = new Training(trainingIndex.getTrainingId(), trainingIndex.getTrainingName(),
				trainingIndex.getAuthority());
		ProfileId profileId = new ProfileId(trainingIndex.getProfileId());
		TrainingUndergone trainingUndergone = new TrainingUndergone(trainingIndex.getDuration(), profileId, training);
		TrainingCoversSkill trainingCoversSkill = new TrainingCoversSkill(trainingIndex.getWeight(), training, skill);
		// profileIdRepository.save(profileId);
		trainingUndergoneRepository.save(trainingUndergone);
		trainingCoversSkillRepository.save(trainingCoversSkill);
		// trainingCoversSkillRepository.delete(trainingCoversSkill);

	}

	@KafkaListener(topics = "ExperienceIndexer123", groupId = "group_json", containerFactory = "experienceKafkaListenerFactory")
	public void consumeJson(ExperienceIndex experienceIndex) {
		System.out.println("Consumed JSON Message: " + experienceIndex);
		// cityRepository.findById(locationListner.getCityName());
		// System.out.println(cityRepository.findById(locationListner.getCityName()));
		ProfileId profileId = new ProfileId(experienceIndex.getProfileId());
		Company company = new Company(experienceIndex.getOrganizationName());
		EmployeeOfRelation employeeOfRelation = new EmployeeOfRelation(experienceIndex.getRole(),
				experienceIndex.getStartDate(), experienceIndex.getEndDate(), profileId, company);
		employeeOfRelationRepository.save(employeeOfRelation);
		// trainingCoversSkillRepository.delete(trainingCoversSkill);

	}

	@KafkaListener(topics = "ProjectIndexer", groupId = "group_json", containerFactory = "projectKafkaListenerFactory")
	public void consumeJson(ProjectIndex projectIndex) {
		System.out.println("Consumed JSON Message: " + projectIndex);
		// cityRepository.findById(locationListner.getCityName());
		// System.out.println(cityRepository.findById(locationListner.getCityName()));
		ProfileId profileId = new ProfileId(projectIndex.getProfileId());
		Skill skill = new Skill(projectIndex.getSkills());
		Project project = new Project(projectIndex.getProjectId(), projectIndex.getProjectTitle(),
				projectIndex.getProjectAt(), projectIndex.getDepartment(), projectIndex.getProjectLocation());
		WorkedInRelation workedInRelation = new WorkedInRelation(projectIndex.getProjectId(), projectIndex.getRole(),
				projectIndex.getFrom(), projectIndex.getTo(), profileId, project);
		UsesSkillRelation usesSkillRelation = new UsesSkillRelation(project, skill);
		workedInRelationRepository.save(workedInRelation);
		usesSkillRelationRepository.save(usesSkillRelation);
		// trainingCoversSkillRepository.delete(trainingCoversSkill);

	}

	@KafkaListener(topics = "QualificationIndexer", groupId = "group_json", containerFactory = "qualificationKafkaListenerFactory")
	public void consumeJson(QualificationIndex qualificationIndex) {
		System.out.println("Consumed JSON Message: " + qualificationIndex);
		// cityRepository.findById(locationListner.getCityName());
		// System.out.println(cityRepository.findById(locationListner.getCityName()));
		ProfileId profileId = new ProfileId(qualificationIndex.getProfileId());
		University university = new University(qualificationIndex.getInstituteName());
		StudiedAtRelation studiedAtRelation = new StudiedAtRelation(qualificationIndex.getQualification(),
				qualificationIndex.getYearOfJoining(), qualificationIndex.getYearOfCompletion(),
				qualificationIndex.getStream(), qualificationIndex.getMarks(), profileId, university);
		// trainingCoversSkillRepository.delete(trainingCoversSkill);
		studiedAtRelationRepository.save(studiedAtRelation);
		// studiedAtRelationRepository.deleteById(studiedAtRelation.getQualification());

	}

}
