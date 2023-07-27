package com.app.gestioneristorante.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.gestioneristorante.model.Merch;
import com.app.gestioneristorante.repository.MerchDAORepository;

@Service
public class MerchService {

	@Autowired MerchDAORepository merchRepo;
	
	@Autowired @Qualifier("maglettaRistoranteBean") private ObjectProvider<Merch> maglettaRistoranteProvider;
	@Autowired @Qualifier("tazzaRistoranteBean") private ObjectProvider<Merch> tazzaRistoranteProvider;
	@Autowired @Qualifier("calziniRistoranteBean") private ObjectProvider<Merch> calziniRistoranteProvider;
	
	public Merch createMagliettaRistorante() {
		return maglettaRistoranteProvider.getObject();
	}

	public Merch createTazzaRistorante() {
		return tazzaRistoranteProvider.getObject();
	}
	
	public Merch createCalziniRistorante() {
		return calziniRistoranteProvider.getObject();
	}
	
// JPA METHODS
	
	public void createMerch(Merch m) {
		merchRepo.save(m);
		System.out.println(m.getName() + " " + m.getPrice() + " SAVED CORRECTLY");
	}
	
	public void updateMerch(Merch m) {
		merchRepo.save(m);
		System.out.println(m.getName() + " " + m.getPrice() + " EDITED CORRECTLY");
	}
	
	public void removeMerch(Merch m) {
		merchRepo.delete(m);
		System.out.println(m.getName() + " " + m.getPrice() + " DELETED CORRECTLY");
	}
	
	public Merch findMerch(long id) {
		return merchRepo.findById(id).get();
	}
	
	public List<Merch> findAllMerch() {
		return (List<Merch>) merchRepo.findAll();
	}
	
}
