package com.cubic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cubic.vo.PersonVO;

@Controller
@RequestMapping("/person")
public class PersonController {

	@RequestMapping(value = "/personform", method = RequestMethod.GET)
	public ModelAndView displayPersonForm() {
		PersonVO person = new PersonVO();
		person.setFirstName("John");
		person.setLastName("Lennon");
		ModelAndView result = new ModelAndView("person");
		result.addObject("person", person);
		return result;
	}

	@RequestMapping(value = "/saveperson", method = RequestMethod.POST)
	public ModelAndView savePerson(@ModelAttribute("person") PersonVO person, BindingResult bindingResult) {
		ModelAndView result = new ModelAndView("person");

		if (StringUtils.isEmpty(person.getFirstName()) || StringUtils.isEmpty(person.getLastName())) {
			result.addObject("resultmsg", "Error OCCURRED!!!");
		} else {
			person.setPk(new Long(2000));
			result.addObject("resultmsg", "PERSON SAVED");
		}

		return result;
	}

}
