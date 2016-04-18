package fr.univ.rouen.davtom.web2project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;

	}
	
	/* @RequestMapping(value = "/stbs", method = RequestMethod.GET)
	    public @ResponseBody StbList getAllStbs() 
	    {
	        StbList stbs = new StbList();
	         
	        StbModel stb1 = new StbModel(1,"Description1");
	        StbModel stb2 = new StbModel(2,"Description2");
	        StbModel stb3 = new StbModel(3,"Description3");
	         
	         
	        stbs.getStb().add(stb1);
	        stbs.getStb().add(stb2);
	        stbs.getStb().add(stb3);
	         
	        return stbs;
	    }*/
	
	
	
}
