package com.kafka.practice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.kafka.practice"})
public class SpringWithKafkaApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringWithKafkaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringWithKafkaApplication.class, args);
		logger.info("KafkaPracticeApplication started successfully...!!!");
	}
}
