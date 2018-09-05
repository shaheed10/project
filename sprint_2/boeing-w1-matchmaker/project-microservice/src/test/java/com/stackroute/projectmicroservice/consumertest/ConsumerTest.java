//package com.stackroute.projectmicroservice.consumertest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Before;
//import org.junit.ClassRule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.listener.MessageListenerContainer;
//import org.springframework.kafka.test.rule.KafkaEmbedded;
//import org.springframework.kafka.test.utils.ContainerTestUtils;
//import org.springframework.kafka.test.utils.KafkaTestUtils;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.stackroute.projectmicroservice.listener.KafkaConsumer;
//import com.stackroute.projectmicroservice.model.Project;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@DirtiesContext
//public class ConsumerTest {
//
//	public Project project = new Project();
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerTest.class);
//
//	private static String RECEIVER_TOPIC = "Projects";
//
//	private KafkaTemplate<String, Project> template;
//
//	@Autowired
//	public KafkaConsumer kafkaConsumer;
//
//	@Autowired
//	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
//
//	@ClassRule
//	public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, RECEIVER_TOPIC);
//
//	@Before
//	public void setUp() throws Exception {
//		// set up the Kafka producer properties
//		Map<String, Object> senderProperties = KafkaTestUtils.senderProps(embeddedKafka.getBrokersAsString());
//
//		// create a Kafka producer factory
//		ProducerFactory<String, Project> producerFactory = new DefaultKafkaProducerFactory<>(senderProperties);
//
//		// create a Kafka template
//		template = new KafkaTemplate<String, Project>(producerFactory);
//		// set the default topic to send to
//		template.setDefaultTopic(RECEIVER_TOPIC);
//
//		// wait until the partitions are assigned
//		for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
//				.getListenerContainers()) {
//			ContainerTestUtils.waitForAssignment(messageListenerContainer, embeddedKafka.getPartitionsPerTopic());
//		}
//	}
//
////	@Test
////	public void testReceive() throws Exception {
////
////		// send the message
////		Project greeting = project;
////		template.sendDefault(greeting);
////		LOGGER.debug("test-sender sent message='{}'", greeting);
////
////		kafkaConsumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
////
////		// check that the message was received
////		assertThat(kafkaConsumer.getLatch().getCount()).isEqualTo(0);
////	}
//
//}
