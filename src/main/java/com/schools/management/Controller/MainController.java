package com.schools.management.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.schools.management.Model.ExternalQueries;
import com.schools.management.Model.User;
import com.schools.management.Model.UserRoles;
import com.schools.management.Service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value={"/home"},method=RequestMethod.GET)    
	public ModelAndView home()   
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
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
		ExternalQueries externalQueries = new ExternalQueries();
		model.addObject("externalQueries", externalQueries);
		model.setViewName("contact");
		return model;
	}
	
	@GetMapping("/signout")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping(value={"/dashboard"},method={RequestMethod.GET,RequestMethod.POST})    
	public ModelAndView dashboard(HttpServletRequest request)  
	{
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		System.out.println("autho" +auth.getAuthorities());
		User user = userService.findUserByEmail(auth.getName());
		model.addObject("userName", user.getName());
		System.out.println("::::"+user.getUserRoles());
		model.addObject("user", user);
		if(user.getUserRoles().equals(UserRoles.GUARDIAN)) {
		model.setViewName("dashboard");
		}else if(user.getUserRoles().equals(UserRoles.TEACHER)){
			model.setViewName("dashboard");
		}else {
			model.setViewName("dashboard");
		}
		return model;
	}
}
