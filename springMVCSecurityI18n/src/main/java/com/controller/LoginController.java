package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {
	
	//root path
	@RequestMapping(method = RequestMethod.GET)
	public String jsp_(ModelMap p) {
		return "index"; 
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(ModelMap p) {
		return "login"; 
	}
	
	@RequestMapping(value="/protectedit"	,method = RequestMethod.GET)
	public String protectedit(ModelMap p) {
		return "protected/protected"; 
	}
	
}
