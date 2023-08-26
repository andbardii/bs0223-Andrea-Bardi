package com.app.gestioneincendi.services;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.app.gestioneincendi.model.Sonda;
import com.app.gestioneincendi.model.Centro;
import com.app.gestioneincendi.repository.SondeRepository;

import jakarta.transaction.Transactional;

@Service
public class SondaService {
	
	Logger log = LoggerFactory.getLogger(SondaService.class);
	
	@Autowired SondeRepository DAO;
	
	@Autowired CentroService CentroSVC;
	@Autowired SegnaleService SegnaleSVC;
	
	@Autowired @Qualifier("sonda") private ObjectProvider<Sonda> provider;

	// POST METHODS
	@Transactional
	public Sonda addSonda(long id, int latitudine, int longitudine) {
		log.info("Aggiungo Sonda al sistema...");
		Sonda s = provider.getObject();
		s.setLatitudine(latitudine);
		s.setLongitudine(longitudine);
		DAO.save(s);
		addToCentro(s.getId(), id);
		log.info("Sonda " + s.getId() + " Aggiunta!");
		System.out.println();
		return s;
	}

	// GET METHODS
	public Sonda findById(long id) {
		Sonda s = DAO.findById(id).get();
		if (s.equals(null)) {
			log.info("Errore...");
			return null;
		}else {
		log.info("Sonda " + s.getId());
		log.info(s.toString());
		return s;
		}
	}
	
	public List<Sonda> findAll(){
		List<Sonda> l = (List<Sonda>)DAO.findAll();
		log.info("Sonde Trovate: ");
		l.forEach(s -> log.info(s.toString()));
		return l;
	}
	
	// PUT METHODS
	public Sonda update(long id,int latitudine,int longitudine,int livelloFumo) {
		log.info("Aggiornamento Sonda...");
		Sonda s = findById(id);

		s.setLatitudine(latitudine);
		s.setLongitudine(longitudine);
		s.setLivellofumo(livelloFumo);
		DAO.save(s);
		log.info("Sonda " + id + " Aggiornata!");
		
		if(livelloFumo > 5) {
			log.info("Segnale in preparazione...");
			SegnaleSVC.addSegnale(s);
			System.out.println();
			return s;
		}else {
			log.info("Livello di fumo Accettabile...");
			System.out.println();
			return s;
		}
		
	}
	
	public void addToCentro(long idSonda, long idCentro) {
		Centro c = CentroSVC.findById(idCentro);
		Sonda s = DAO.findById(idSonda).get();
		List<Sonda> ls = c.getSonde();
		ls.add(s);
		c.setSonde(ls);
		CentroSVC.toggleSonde(c);
		log.info("Sonda " + s.getId() + " Aggiunta al Centro!");
	}
	
	// OTHER METHODS
	@Scheduled(fixedRate = 10000)
    public void random() {
        Random random = new Random();
        List<Sonda> l = (List<Sonda>)DAO.findAll();
        
        long randomId = random.nextLong(l.size());
        if (randomId == 0) {
        	randomId ++;
        }
        int randomLatitudine = random.nextInt(90);
        int randomLongitudine = random.nextInt(180);
        int randomLivelloFumo = random.nextInt(10);

        update(randomId, randomLatitudine, randomLongitudine, randomLivelloFumo);
    }
}
