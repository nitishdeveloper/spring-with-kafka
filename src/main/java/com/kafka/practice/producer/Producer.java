package com.kafka.practice.producer;

import com.kafka.practice.constants.AppConstants;
import com.kafka.practice.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {

	@Autowired
	private KafkaTemplate<String , Object> kafkaTemplate;

	public void sender(Employee employee){
		log.info("sending data : {} to topic : {}" ,employee , AppConstants.TOPIC_NAME);
		this.kafkaTemplate.send(AppConstants.TOPIC_NAME , employee);
	}
}
