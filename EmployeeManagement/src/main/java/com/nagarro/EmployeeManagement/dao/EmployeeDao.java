package com.nagarro.EmployeeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.EmployeeManagement.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer>
{
	
}
