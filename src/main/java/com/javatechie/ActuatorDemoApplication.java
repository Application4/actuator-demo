package com.javatechie;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.dto.Employee;
import com.javatechie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@Slf4j
public class ActuatorDemoApplication {

	@Autowired
	private EmployeeService service;

	@GetMapping("/employees")
	public List<Employee> getEmployees() throws JsonProcessingException {
		List<Employee> employees = service.getEmployees();
		log.info("EmployeeController:getEmployees fetch all employees response {} ",new ObjectMapper().writeValueAsString(employees));
		return employees;
	}


	public static void main(String[] args) {

		SpringApplication.run(ActuatorDemoApplication.class, args);
	}



}
