package com.kafka.practice.services.impl;


import com.kafka.practice.model.Employee;
import com.kafka.practice.services.KafkaServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;



@Service @Slf4j
public class KafkaServicesImpl implements KafkaServices {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void pushkafkaToMongo(Employee employeeData) {
		log.info("data being sending to mongo -> {}",employeeData);
		Employee  empResponse  =  mongoTemplate.save(employeeData);
		log.info("response : {}",empResponse);
	}
}
