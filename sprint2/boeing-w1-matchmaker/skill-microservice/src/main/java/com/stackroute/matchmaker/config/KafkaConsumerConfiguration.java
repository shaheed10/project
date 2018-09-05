package com.stackroute.matchmaker.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.stackroute.matchmaker.model.Skills;

import java.util.HashMap;
import java.util.Map;

@EnableKafka // lets kafka know that there are listeners in application
@Configuration
public class KafkaConsumerConfiguration {

	// Any other way to do this binding?
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;

	// configuration for consuming string or default messages
	// defining consumer factory for configuration
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(config);
	}

	// setting the consumer factory with the cofiguration
	// kafkaListenerContainerFactory is default container factory used in kafka
	// listener
	// why concurrent kafka factory?
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	// configuration for consuming json message
	// defining consumer factory for configuration
	@Bean
	public ConsumerFactory<String, Skills> skillConsumerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(Skills.class));
	}

	// setting the consumer factory with the cofiguration
	// locationkafkaListenerFactory is used in kafka listener
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Skills> skillKafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Skills> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(skillConsumerFactory());
		return factory;
	}

}
