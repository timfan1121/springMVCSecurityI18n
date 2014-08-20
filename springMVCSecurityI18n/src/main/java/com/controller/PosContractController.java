package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/posContract/html")
public class PosContractController {
	
	//root path
	@RequestMapping(method = RequestMethod.GET)
	public String jsp_(ModelMap p) {
		return "posContract/posContractQuery"; 
	}
}
