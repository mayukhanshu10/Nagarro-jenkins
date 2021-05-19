package com.nagarro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.dao.HRDao;
import com.nagarro.models.Employee;
import com.nagarro.models.HRModel;

@Controller
public class Login
{
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws JsonMappingException, JsonProcessingException
	{
		ModelAndView mv=new ModelAndView();
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		HRModel user=new HRDao().authentication(userId, password);
		if(user==null)
		{
			mv.setViewName("index.jsp");
			mv.addObject("auth", "false");
		}
		else
		{
			RestTemplate restTemplate=new RestTemplate();
			String jsonEmpList=restTemplate.getForObject("http://localhost:8082/employees", String.class);
	//		ResponseEntity<Employee> responseEntity =restTemplate.getForEntity("http://localhost:8082/employee/500", Employee.class);
	//		Employee[] empList = responseEntity.getBody();
			ObjectMapper m=new ObjectMapper();
			
			List<Employee> empList = m.readValue(jsonEmpList, new TypeReference<List<Employee>>(){});
			System.out.println(empList);
			
			
			mv.addObject("auth", "true");
			mv.addObject("user",user.getFirstName());
			mv.addObject("empList",empList);
			mv.setViewName("employeedetails.jsp");
			

			
		
		}
		
		return mv;
		
	}
}