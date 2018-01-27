package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.People;
import com.service.PeopleService;

@Controller
public class HelloWorldController {

	@Autowired
	private PeopleService peopleService;

	@GetMapping("/Home")
	public String goToHome() {
		return "redirect:/";
	}
	
	@GetMapping("/ViewPeople")
	public String viewPeople(ModelMap model) {
		model.addAttribute("peopleList", peopleService.list());
		return "ViewPeople";
	}

	@PostMapping("/savePeople")
	public String savePeople(@ModelAttribute People people) {
		peopleService.save(people);
		return "redirect:/ViewPeople";
	}

	// Problem when using @DeleteMapping - Request method GET not supported
	@GetMapping("/deletePeople/{peopleId}")
	public String deletePeople(@PathVariable("peopleId") int peopleId) {
		peopleService.delete(peopleId);
		return "redirect:/ViewPeople";
	}
	
	// Problem when using @PutMapping - Request method GET not supported
	@GetMapping(value = "/updatePeople/{peopleId}/{peopleName}/{emailPrefix}/{emailSuffix}")
	public String updatePeople(@PathVariable("peopleId") int peopleId, @PathVariable("peopleName") String peopleName, @PathVariable("emailPrefix") String emailPrefix, @PathVariable("emailSuffix") String emailSuffix) {
		String peopleEmail = emailPrefix + "." + emailSuffix;
		peopleService.update(peopleId, peopleName, peopleEmail);
		return "redirect:/ViewPeople";
	}
}
