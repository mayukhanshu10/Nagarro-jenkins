package com.nagarro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Logout 
{
	@RequestMapping(value = "/Logout", method = RequestMethod.POST)
	public String logout(ModelAndView mv)
	{
		mv.clear();
		return "index.jsp";
	}
}
