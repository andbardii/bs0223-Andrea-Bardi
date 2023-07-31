package com.app.about.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("")
	public String getHome() {
		return "page";
	}
	@GetMapping("/rubrica")
	public String getRubrica() {
		return "rubrica";
	}
	
}
