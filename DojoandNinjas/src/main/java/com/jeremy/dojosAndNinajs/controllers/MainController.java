package com.jeremy.dojosAndNinajs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeremy.dojosAndNinajs.models.Dojo;
import com.jeremy.dojosAndNinajs.models.Ninja;
import com.jeremy.dojosAndNinajs.services.DojoService;
import com.jeremy.dojosAndNinajs.services.NinjaService;



@Controller
public class MainController {
	
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String showCreateView(@ModelAttribute("dojo") Dojo dojo) {
		return "create.jsp";
	}
	
	@PostMapping("/")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "create.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/ninja/new")
	public String showNinjaCreateView(@ModelAttribute("ninja") Ninja ninja, Model model) {
		
		List<Dojo> allDojos = dojoService.showAllDojos();
		model.addAttribute("allDojos", allDojos);
		return "createNinja.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "createNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojoDetails(@PathVariable Long id, Model model) {
		Dojo dojo = dojoService.showOne(id);
		model.addAttribute("dojo",dojo);
		return "details.jsp";
		
	}
}
