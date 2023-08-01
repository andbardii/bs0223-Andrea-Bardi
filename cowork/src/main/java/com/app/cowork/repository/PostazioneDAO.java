package com.app.cowork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.cowork.model.Postazione;
import com.app.cowork.model.TipoPostazione;

public interface PostazioneDAO extends CrudRepository<Postazione, Long> {
	
	@Query("SELECT p FROM Postazione p WHERE p.tipo LIKE :tipo AND p.edificio.citta LIKE :citta")
    List<Postazione> findByTipoAndCittaOfEdificio(@Param("tipo") TipoPostazione tipo, @Param("citta") String citta);
	
}
