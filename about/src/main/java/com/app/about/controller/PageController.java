package com.app.about.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.app.about.model.Utente;
import com.app.about.service.UtenteService;


public class PageController {
	
	@Autowired UtenteService uSvc;
	
	@GetMapping("")
	public String getHome() {
		return "page";
	}
	@GetMapping("/rubrica")
	public ModelAndView getRubrica() {
		List<Utente> listaContatti = uSvc.findAllRubrica();
		ModelAndView model = new ModelAndView("rubrica"); 
		model.addObject("lista", listaContatti);
		return model;
	}
	@GetMapping("/rubrica/{id}")
	public ModelAndView getRubrica(@PathVariable Long id) {
		Utente contatto = uSvc.findById(id);
		ModelAndView model = new ModelAndView("contatto"); 
		model.addObject("cont", contatto);
		return model;
	}
	
}
