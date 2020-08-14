package com.kafka.practice.consumer;

import com.kafka.practice.constants.AppConstants;
import com.kafka.practice.model.Employee;
import com.kafka.practice.services.KafkaServices;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

	@Autowired
	private KafkaServices kafkaServices;

	@KafkaListener(groupId = AppConstants.GROUP_ID,
			containerFactory = "kafkaListenerContainerFactory",
			topicPartitions = {
			@TopicPartition(topic = AppConstants.TOPIC_NAME , partitions = { "0" })
	})
	public void consumer_1(ConsumerRecord<String , Employee> message , @Payload Employee employee) {
		log.info("partition_{} | offSet : {}", message.partition() ,message.offset());
		this.kafkaServices.pushkafkaToMongo(employee);
	}

	@KafkaListener(groupId = AppConstants.GROUP_ID,
			containerFactory = "kafkaListenerContainerFactory",
			topicPartitions = {
			@TopicPartition(topic = AppConstants.TOPIC_NAME , partitions = { "1" })
	})
	public void consumer_2(ConsumerRecord<String , Employee> message , @Payload Employee employee) {
		log.info("partition_{} | offSet : {}", message.partition() ,message.offset());
		this.kafkaServices.pushkafkaToMongo(employee);
	}

	@KafkaListener(groupId = AppConstants.GROUP_ID,
			containerFactory = "kafkaListenerContainerFactory",
			topicPartitions = {
			@TopicPartition(topic = AppConstants.TOPIC_NAME , partitions = { "2" })
	})
	public void consumer_3(ConsumerRecord<String , Employee> message , @Payload Employee employee) {
		log.info("partition_{} | offSet : {}", message.partition() ,message.offset());
		this.kafkaServices.pushkafkaToMongo(employee);
	}
}
