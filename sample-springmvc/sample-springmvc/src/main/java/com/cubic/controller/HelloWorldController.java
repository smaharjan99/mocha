package com.cubic.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hw")
public class HelloWorldController {

	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		ModelAndView result = new ModelAndView("hello");
		result.addObject("message", "This is Spring MVC hello");
		return result;
	}

	@RequestMapping("/wassup")
	public ModelAndView wassup() {
		ModelAndView result = new ModelAndView("hello");
		result.addObject("message", "Wassup in here?!@");
		return result;
	}

	@RequestMapping("/red")
	public String red() {
		return "redirect:/hw/welcome";
	}

	@RequestMapping("/ft")
	public String forwardTest() {
		return "forward:/hw/wassup";
	}

	@RequestMapping(value = "/qp", method = RequestMethod.GET)
	public ModelAndView sayHello(@RequestParam("firstName") final String firstName,
			@RequestParam("lastName") final String lastName) {
		ModelAndView result = new ModelAndView("hello");
		result.addObject("message", "Hello " + firstName + "," + lastName);
		return result;
	}

	@RequestMapping(value = "/qpmap", method = RequestMethod.GET)
	public ModelAndView sayHelloMap(@RequestParam final Map<String, String> requestMap) {
		ModelAndView result = new ModelAndView("hello");
		result.addObject("message", "Hello " + requestMap.get("firstName") + "," + requestMap.get("lastName"));
		return result;
	}

	@RequestMapping(value = "/pp/{firstName}/{lastName}", method = RequestMethod.GET)
	public ModelAndView sayPP(@PathVariable("firstName") final String firstName,
			@PathVariable("lastName") final String lastName) {
		ModelAndView result = new ModelAndView("hello");
		result.addObject("message", "Hello " + firstName + "," + lastName);
		return result;
	}

	@RequestMapping(value = "/ppmap/{firstName}/{lastName}", method = RequestMethod.GET)
	public ModelAndView sayPPmap(@PathVariable final Map<String, String> requestMap) {
		String firstName = requestMap.get("firstName");
		String lastName = requestMap.get("lastName");
		ModelAndView result = new ModelAndView("hello");
		result.addObject("message", "Hello " + firstName + ", " + lastName);
		return result;
	}
}
