package com.kafka.practice.services;

import com.kafka.practice.model.Employee;

public interface KafkaServices {
	void pushkafkaToMongo(Employee employeeData);
}
