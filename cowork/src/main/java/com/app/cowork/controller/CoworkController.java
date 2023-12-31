package com.app.cowork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.cowork.model.Prenotazione;
import com.app.cowork.service.EdificioService;
import com.app.cowork.service.PostazioneService;
import com.app.cowork.service.PrenotazioneService;
import com.app.cowork.service.UtenteService;

@Controller
public class CoworkController {

	@Autowired EdificioService edificioSvc;
	@Autowired PostazioneService postazioneSvc;
	@Autowired PrenotazioneService prenotazioneSvc;
	@Autowired UtenteService utenteSvc;
	
	@GetMapping("")
	public String getHome() {
		return "index";
	}
	@GetMapping("/prenota")
	public String getPrenota() {
		return "prenota";
	}
	@GetMapping("/prenotazione")
	public ModelAndView getPrenotazioni() {
		List<Prenotazione> listaPrenotazioni = prenotazioneSvc.findAll();
		ModelAndView model = new ModelAndView("prenotazioni"); 
		model.addObject("lista", listaPrenotazioni);
		return model;
	}
}
