package com.schools.management.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	/*
	 * @RequestMapping(value={"/home"},method=RequestMethod.GET) public ModelAndView
	 * home() { ModelAndView model = new ModelAndView(); model.setViewName("index");
	 * return model; }
	 */
	
	@RequestMapping(value={"/home"},method=RequestMethod.GET)    
	public String home1()  
	{
	   return "index";
	}
	
	@RequestMapping(value={"/login"},method={RequestMethod.GET})    
	public ModelAndView login()  
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value={"/about"},method=RequestMethod.GET)    
	public ModelAndView about()  
	{
	   ModelAndView model = new ModelAndView();
	   model.setViewName("about");
	   return model;
	}
	
	@RequestMapping(value={"/teachers"},method={RequestMethod.GET})    
	public ModelAndView teachers()  
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("teachers");
		return model;
	}
	
	@RequestMapping(value={"/contact"},method={RequestMethod.GET})    
	public ModelAndView contact()  
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("contact");
		return model;
	}
}
