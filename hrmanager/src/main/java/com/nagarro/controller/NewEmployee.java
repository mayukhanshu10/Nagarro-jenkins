package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
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
public class NewEmployee
{
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(HttpServletRequest request,HttpServletResponse response,ModelAndView mv) throws JsonMappingException, JsonProcessingException
	{
		int code=Integer.parseInt(request.getParameter("code"));
		String name=request.getParameter("name");
		String location=request.getParameter("location");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		
		Employee emp=new Employee(code,name,location,email,dob);
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.postForObject("http://localhost:8082/employee", emp, null);
		
		String jsonEmpList=restTemplate.getForObject("http://localhost:8082/employees", String.class);
		ObjectMapper m=new ObjectMapper();
		List<Employee> empList = m.readValue(jsonEmpList, new TypeReference<List<Employee>>(){});
		
		mv.addObject("empList",empList);
		mv.setViewName("redirect:employeedetails.jsp");
		return mv;
	}
}

