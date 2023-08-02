package com.app.worktest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.worktest.service.PrenotazioneService;

@Controller
public class PageController {
	
	@Autowired PrenotazioneService prenotazioneSvc;

	@GetMapping("")
	public String getHome() {
		return "index";
	}
	
}
