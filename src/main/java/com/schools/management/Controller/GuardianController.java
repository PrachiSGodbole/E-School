package com.schools.management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.schools.management.Service.GradesService;

@Controller
public class GuardianController {

	@Autowired
	private GradesService gradesService;
	
	@RequestMapping(value={"/student"},method=RequestMethod.POST)    
	public ModelAndView student()   
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value={"/notices"},method={RequestMethod.POST})    
	public ModelAndView notices()  
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
}
