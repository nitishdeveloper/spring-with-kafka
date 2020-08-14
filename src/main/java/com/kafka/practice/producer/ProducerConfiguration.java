package com.kafka.practice.producer;

import com.kafka.practice.constants.AppConstants;
import com.kafka.practice.model.Employee;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class ProducerConfiguration {

//	@Autowired
//	private KafkaProperties kafkaProperties;

	@Bean
	public Map<String, Object> producerConfigs() {
		Map<String, Object> properties =new HashMap<>();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG , AppConstants.BOOTSTRAP_SERVER);
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		properties.put(ProducerConfig.RETRIES_CONFIG,AppConstants.RETRIES_CONFIG_VALUE);
		properties.put(ProducerConfig.BATCH_SIZE_CONFIG,AppConstants.BATCH_SIZE_CONFIG_VALUE);
		properties.put(ProducerConfig.ACKS_CONFIG , AppConstants.ACKNOWLEDGE_CONFIG_VALUE);
		properties.put(ProducerConfig.LINGER_MS_CONFIG , AppConstants.LINGER_MS_CONFIG_VALUE);
		properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, AppConstants.BUFFER_MEMORY_CONFIG_VALUE);
		return properties;
	}

	@Bean
	public ProducerFactory<String , Object> producerFactory(){
		return new DefaultKafkaProducerFactory<String, Object>(producerConfigs());
	}

	@Bean
	public KafkaTemplate<String, Object> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	public Producer sender() {
		return new Producer();
	}
}
