package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.models.Employee;


@Controller
public class UpdateEmployee 
{
	@RequestMapping("/updateEmployee/{code}")
	public ModelAndView getEmployee(@PathVariable("code") int code,ModelAndView mv) throws JsonMappingException, JsonProcessingException
	{
		System.out.println("hello");
		RestTemplate restTemplate=new RestTemplate();
		Employee emp=restTemplate.getForObject("http://localhost:8082/employee/"+code, Employee.class);
		System.out.println(emp);
		mv.addObject("empData", emp);
		mv.setViewName("/edit.jsp");
		return mv;
	}
	
	@RequestMapping(value = "/updateEmployee/updatedEmployee/{code}")
	public ModelAndView updatedEmployee(@PathVariable("code") int code,ModelAndView mv,HttpServletRequest request,HttpServletResponse response) throws JsonMappingException, JsonProcessingException
	{
		String name=request.getParameter("name");
		String location=request.getParameter("location");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		Employee emp=new Employee(code,name,location,email,dob);
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.put("http://localhost:8082/employee",emp);
		
		String jsonEmpList=restTemplate.getForObject("http://localhost:8082/employees", String.class);
		ObjectMapper m=new ObjectMapper();
		List<Employee> empList = m.readValue(jsonEmpList, new TypeReference<List<Employee>>(){});
		//		Employee emp=m.readValue(e, Employee.class);
		System.out.println(empList);
		
		mv.addObject("empList",empList);
		mv.setViewName("redirect:/employeedetails.jsp");
		
		return mv;
	}
}
