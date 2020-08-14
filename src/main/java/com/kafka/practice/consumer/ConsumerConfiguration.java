package com.kafka.practice.consumer;


import com.kafka.practice.constants.AppConstants;
import com.kafka.practice.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ConsumerConfiguration {

//		@Autowired
//	    private KafkaProperties kafkaProperties;

	@Bean
	public ConsumerFactory<String, Employee> consumerFactory() {
		Map<String , Object> properties = new HashMap<>();
		final JsonDeserializer<Employee> deserializer = new JsonDeserializer<>(Employee.class);
		deserializer.setRemoveTypeHeaders(false);
		deserializer.addTrustedPackages("com.kafka.practice.model");
		deserializer.setUseTypeMapperForKey(true);
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG , AppConstants.BOOTSTRAP_SERVER);
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,deserializer);
		properties.put(ConsumerConfig.GROUP_ID_CONFIG,AppConstants.CONSUMER_GROUP);
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG ,AppConstants.AUTO_OFFSET_RESET_CONFIG_VALUE);
		properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,AppConstants.ENABLE_AUTO_COMMIT_CONFIG_VALUE);
		properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG , AppConstants.AUTO_COMMIT_INTERVAL_MS_CONFIG_VALUE);
		properties.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG , AppConstants.HEARTBEAT_INTERVAL_MS_CONFIG_VALUE);
		properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, AppConstants.SESSION_TIMEOUT_MS_CONFIG_VALUE);
//		properties.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG , AppConstants.MAX_PARTITION_FETCH_BYTES_CONFIG_VALUE);
		return new DefaultKafkaConsumerFactory<>(properties,new StringDeserializer(), deserializer);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Employee> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Employee> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public Consumer receiver() {
		return new Consumer();
	}
}
