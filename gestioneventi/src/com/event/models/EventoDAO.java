package com.event.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.event.utils.JpaUtil;

public class EventoDAO {
	
	private static EntityManager em;
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	static {
		try {
			em = emf.createEntityManager();
		} catch (Throwable e) {
			System.err.println("EntityManager creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static EntityManager getEntityManager() {
		return em;
	}
	
	public void saveEvent(Evento e) {
	
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			System.out.println(e);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public Evento getEventById(long id) {
		
		EntityManager em = getEntityManager();
		Evento e = null;
		
		try {
			em.getTransaction().begin();
			e = em.find(Evento.class, id);
			em.getTransaction().commit();
			System.out.println(e);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return e;
	}
	
	public void deleteEvent(Evento e) {
		
		EntityManager em = getEntityManager();
		
		try {
			em.getTransaction().begin();
			System.out.println(e);
			em.remove(e);
			em.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void refreshEvent(Evento e) {
		EntityManager em = getEntityManager();
		
		try {
			em.refresh(e);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
