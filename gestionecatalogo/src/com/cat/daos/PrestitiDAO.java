package com.cat.daos;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cat.models.Book;
import com.cat.models.Prestito;
import com.cat.models.Utente;
import com.cat.utils.JpaUtil;

public class PrestitiDAO {

	private static final Logger log = LoggerFactory.getLogger(PrintableDAO.class);
	
	public void saveUser(Utente u) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			log.info("User saved correctly");
		} catch (Exception e) {
			em.getTransaction().rollback();

			log.error("Error saving : " + u.getClass().getSimpleName(), e);
			throw e;

		} finally {
			em.close();
		}

	}

	public Utente getUser(long nTessera) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			log.info("Utente : " + em.find(Utente.class, nTessera));
			return em.find(Utente.class, nTessera);
		} finally {
			em.close();
		}

	}

	public void savePrestito(Prestito p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			log.info("Prestito saved correctly");
		} catch (Exception e) {
			em.getTransaction().rollback();

			log.error("Error saving : " + p.getClass().getSimpleName(), e);
			throw e;

		} finally {
			em.close();
		}

	}

	public void deletePrestito(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Prestito.class, id));
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Error deleting" + e);
			throw e;

		} finally {
			em.close();
		}

	}
}
