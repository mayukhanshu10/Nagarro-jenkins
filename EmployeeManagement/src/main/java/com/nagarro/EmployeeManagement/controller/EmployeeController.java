package com.nagarro.EmployeeManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.EmployeeManagement.dao.EmployeeDao;
import com.nagarro.EmployeeManagement.model.Employee;

@RestController
public class EmployeeController
{
	@Autowired
	EmployeeDao repo;
	
	@RequestMapping("/employees")
	public List<Employee> getEmployees()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/employee/{code}")
	public Optional<Employee> getEmployeeById(@PathVariable("code") int code)
	{
		return repo.findById(code);
	}
	
	@PostMapping("/employee")
	public void addEmployee(@RequestBody Employee emp)
	{
		repo.save(emp);
	}
	
	@PutMapping("/employee")
	public void updateEmployee(@RequestBody Employee emp)
	{
		repo.save(emp);
	}

		

}