package com.app.gestioneincendi.services;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.gestioneincendi.model.Sonda;
import com.app.gestioneincendi.model.Centro;
import com.app.gestioneincendi.repository.SondeRepository;

@Service
public class SondaService {
	
	Logger log = LoggerFactory.getLogger(SondaService.class);
	
	@Autowired SondeRepository DAO;
	
	@Autowired CentroService CentroSVC;
	
	@Autowired @Qualifier("sonda") private ObjectProvider<Sonda> provider;

	// POST METHODS
	public Sonda addSonda(long id, int latitudine, int longitudine) {
		Centro c = CentroSVC.findById(id);
		Sonda s = provider.getObject();
		s.setLatitudine(latitudine);
		s.setLongitudine(longitudine);
		DAO.save(s);
		Sonda sid = DAO.findByLatitudineAndLongitudine(latitudine, longitudine);
		addToCentro(sid.getId(), id);
		log.info("Sonda Aggiunta: " + s.toString());
		return s;
	}

	// GET METHODS
	public Sonda findById(long id) {
		Sonda s = DAO.findById(id).get();
		log.info("Sonda Trovata: " + s.toString());
		log.info(s.toString());
		return s;
	}
	
	public List<Sonda> findAll(){
		List<Sonda> l = (List<Sonda>)DAO.findAll();
		log.info("Sonda Trovate: ");
		l.forEach(s -> log.info(s.toString()));
		return l;
	}
	// PUT METHODS
	public Sonda update(long id,int latitudine,int longitudine,int livelloFumo) {
		Sonda s = DAO.findById(id).get();
		s.setLatitudine(latitudine);
		s.setLongitudine(longitudine);
		s.setLivellofumo(livelloFumo);
		DAO.save(s);
		log.info("Sonda " + id + " Aggiornata!" );
		return s;
		
	}
	
	public void addToCentro(long idSonda, long idCentro) {
		Centro c = CentroSVC.findById(idCentro);
		Sonda s = findById(idSonda);
		List<Sonda> ls = c.getSonde();
		ls.add(s);
		c.setSonde(ls);
		CentroSVC.toggleSonde(c);
		log.info("Sonda Aggiunta al Centro: " + s.toString());
	}
	// OTHER METHODS
	public void random() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        Runnable randomDataGenerator = () -> {
            Random random = new Random();
            long randomId = random.nextLong(findAll().size());
            int randomLatitudine = random.nextInt(90);  
            int randomLongitudine = random.nextInt(180);
            int randomLivelloFumo = random.nextInt(10);

            update(randomId, randomLatitudine, randomLongitudine, randomLivelloFumo);
        };

        executorService.scheduleAtFixedRate(randomDataGenerator, 0, 20, TimeUnit.SECONDS);
    }
}
