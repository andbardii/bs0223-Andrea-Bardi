package com.cat.daos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cat.models.Book;
import com.cat.models.Magazine;
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

	public void terminaPrestito(long id){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
		em.getTransaction().begin();
		Prestito p = em.find(Prestito.class, id);
		p.setDataFine(LocalDate.now());
		em.merge(p);
		em.getTransaction().commit();
		System.out.println("Complimenti " + p.getUtente().getNome() + " hai chiuso il prestito con id: " + p.getId());
		}catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Error updating" + e);
			throw e;
		}finally{
			em.close();
		}
	}

	public Prestito getPrestito(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			log.info("Prestito : " + em.find(Prestito.class, id));
			return em.find(Prestito.class, id);
		} finally {
			em.close();
		}

	}
//	QUERY
	public void findUsersPresitiBook(long nTessera) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			Query query = em.createNamedQuery("findUsersPresitiBook");
			query.setParameter("nTessera", nTessera);
			List<Book> resultBook = query.getResultList();
			resultBook.forEach(b -> log.info(b.toString()));
		}finally{
			em.close();
		}
	}
	
	public void findUsersPresitiMag(long nTessera) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			Query query = em.createNamedQuery("findUsersPresitiMag");
			query.setParameter("nTessera", nTessera);
			List<Magazine> resultBook = query.getResultList();
			resultBook.forEach(b -> log.info(b.toString()));
		}finally{
			em.close();
		}
	}

	public void findDelayPrestitiBook() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			Query query = em.createNamedQuery("findDelayPrestitiBook");
			List<Book> resultBook = query.getResultList();
			resultBook.forEach(b -> log.info(b.toString()));
		}finally{
			em.close();
		}
	}
	
	public void findDelayPrestitiMag() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			Query query = em.createNamedQuery("findDelayPrestitiMag");
			List<Magazine> resultBook = query.getResultList();
			resultBook.forEach(b -> log.info(b.toString()));
		}finally{
			em.close();
		}
	}
}
