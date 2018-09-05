package com.stackroute.downstreamservice.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.stackroute.downstreamservice.model.Academics;
import com.stackroute.downstreamservice.model.Experience;
import com.stackroute.downstreamservice.model.Location;
import com.stackroute.downstreamservice.model.PersonalInfo;
import com.stackroute.downstreamservice.model.Project;
import com.stackroute.downstreamservice.model.Skills;
import com.stackroute.downstreamservice.model.Training;
import com.stackroute.downstreamservice.repository.AcademiesRepository;
import com.stackroute.downstreamservice.repository.ExperienceRepository;
import com.stackroute.downstreamservice.repository.LocationRepository;
import com.stackroute.downstreamservice.repository.PersonalInfoRepository;
import com.stackroute.downstreamservice.repository.ProjectRepository;
import com.stackroute.downstreamservice.repository.SkillsRepository;
import com.stackroute.downstreamservice.repository.TrainingRepository;
import com.stackroute.downstreamservice.stream.AcademiesStream;
import com.stackroute.downstreamservice.stream.ExperienceStream;
import com.stackroute.downstreamservice.stream.LocationStream;
import com.stackroute.downstreamservice.stream.PersonalInfoStream;
import com.stackroute.downstreamservice.stream.ProjectStream;
import com.stackroute.downstreamservice.stream.SkillsStream;
import com.stackroute.downstreamservice.stream.TrainingStream;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@EnableBinding({ AcademiesStream.class, ExperienceStream.class, LocationStream.class, PersonalInfoStream.class,
		ProjectStream.class, SkillsStream.class, TrainingStream.class })
public class DownStreamListener {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private AcademiesRepository academiesRepository;
	private ExperienceRepository experienceRepository;
	private LocationRepository locationRepository;
	private PersonalInfoRepository personalInfoRepository;
	private ProjectRepository projectRepository;
	private SkillsRepository skillsRepository;
	private TrainingRepository trainingRepository;

	@Autowired
	public DownStreamListener(AcademiesRepository academiesRepository, ExperienceRepository experienceRepository,
			LocationRepository locationRepository, PersonalInfoRepository personalInfoRepository,
			ProjectRepository projectRepository, SkillsRepository skillsRepository,
			TrainingRepository trainingRepository) {

		this.academiesRepository = academiesRepository;
		this.experienceRepository = experienceRepository;
		this.locationRepository = locationRepository;
		this.personalInfoRepository = personalInfoRepository;
		this.projectRepository = projectRepository;
		this.skillsRepository = skillsRepository;
		this.trainingRepository = trainingRepository;
	}

	@StreamListener(ExperienceStream.INPUT)
	public void experiencePost(@Payload Experience experience) {
		logger.info("11111 reading from topic ExperienceStream " + experience);
		try {
			experienceRepository.save(experience);
		} catch (Exception e) {
			logger.info("Error in saving");
		}
		logger.info(experience.toString() + " experience");
	}

	@StreamListener(AcademiesStream.INPUT)
	public void academiesPost(@Payload Academics academies) {
		try {
			academiesRepository.save(academies);
		} catch (Exception e) {
			logger.info("Error in saving");
		}
		logger.info(academies.toString() + " academies");
	}

	@StreamListener(LocationStream.INPUT)
	public void locationPost(@Payload Location location) {
		try {
			locationRepository.save(location);
		} catch (Exception e) {
			logger.info("Error in saving");
		}
		logger.info(location.toString() + " location");
	}

	@StreamListener(PersonalInfoStream.INPUT)
	public void personalInfoPost(@Payload PersonalInfo personalInfo) {
		try {
			personalInfoRepository.save(personalInfo);
		} catch (Exception e) {
			logger.info("Error in saving");
		}
		logger.info(personalInfo.toString() + " personal info");
	}

	@StreamListener(ProjectStream.INPUT)
	public void projectPost(@Payload Project project) {
		try {
			projectRepository.save(project);
		} catch (Exception e) {
			logger.info("Error in saving");
		}
		logger.info(project.toString() + " project");
	}

	@StreamListener(SkillsStream.INPUT)
	public void skillsPost(@Payload Skills skills) {
		try {
			skillsRepository.save(skills);
		} catch (Exception e) {
			logger.info("Error in saving");
		}
		logger.info(skills.toString() + " skills");
	}

	@StreamListener(TrainingStream.INPUT)
	public void TrainingPost(@Payload Training training) {
		try {
			trainingRepository.save(training);
		} catch (Exception e) {
			logger.info("Error in saving");
		}
		logger.info(training.toString() + " training");
	}

}
