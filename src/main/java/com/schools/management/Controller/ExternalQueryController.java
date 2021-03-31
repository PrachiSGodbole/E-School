package com.schools.management.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.schools.management.Model.ExternalQueries;
import com.schools.management.Service.ExternalQueryService;

@Controller
public class ExternalQueryController {
	
	@Autowired
	private ExternalQueryService externalQueryService ;

	@RequestMapping(value={"/contactResponse"},method={RequestMethod.POST})    
	public ModelAndView contact(@Valid ExternalQueries externalQueries, BindingResult bindingResult)  
	{
		externalQueryService.saveQuery(externalQueries);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("contact");
		model.addObject("externalQueries", new ExternalQueries());
		model.addObject("msg", "Message sent successfully!");
		return model;
	}
}
