package com.kafka.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class Employee {
	@Field("employeeId")
	private int employeeId;

	@Field("firstname")
	private String firstname;

	@Field("lastname")
	private String lastname;

	@Field("address")
	private String address;

	@Field("salary")
	private double salary;
}
