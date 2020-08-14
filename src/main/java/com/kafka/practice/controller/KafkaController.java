package com.kafka.practice.controller;

import com.kafka.practice.model.Employee;
import com.kafka.practice.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

	private final Producer producer;

	@Autowired
	public KafkaController(Producer producer) {
		this.producer = producer;
	}

	@PostMapping("/publish")
	public String sendMessageToKafkaTopic(@RequestBody Employee employee){
		this.producer.sender(employee);
		return "Successfully Published...!!!";
	}
}
