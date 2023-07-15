package com.cat.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cat.models.Book;
import com.cat.models.Magazine;
import com.cat.models.Printable;
import com.cat.utils.JpaUtil;

public class PrintableDAO {
	
	private static final Logger log = LoggerFactory.getLogger(PrintableDAO.class);
	
	public void savePrint(Printable p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			log.info("Printable saved correctly");
		} catch (Exception e) {
			em.getTransaction().rollback();

			log.error("Error saving : " + p.getClass().getSimpleName(), e);
			throw e;

		} finally {
			em.close();
		}

	}

	public Book getBook(long ISBN) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			log.info("Book : " + em.find(Book.class, ISBN));
			return em.find(Book.class, ISBN);
		} finally {
			em.close();
		}

	}
	
	public Magazine getMagazine(long ISBN) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			log.info("Magazine : " + em.find(Magazine.class, ISBN));
			return em.find(Magazine.class, ISBN);
		} finally {
			em.close();
		}

	}

	public void deleteBook(long ISBN) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Book.class, ISBN));
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Error deleting" + e);
			throw e;

		} finally {
			em.close();
		}

	}
	
	public void deleteMagazine(long ISBN) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Magazine.class, ISBN));
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Error deleting" + e);
			throw e;

		} finally {
			em.close();
		}

	}
	
	public void refreshBook(long ISBN) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
			try {
				em.refresh(em.find(Magazine.class, ISBN));
			} finally {
				em.close();
			}
		
	}
	
	public void refreshMagazine(long ISBN) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
			try {
				em.refresh(em.find(Magazine.class, ISBN));
			} finally {
				em.close();
			}
		
	}

//	QUERY
	public void getBookByTitle(String title) {
			EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
			
			try {
				Query query = em.createNamedQuery("Book.findByTitle");
				query.setParameter("book_title", title);
				List<Book> resultBook = query.getResultList();
				resultBook.forEach(b -> log.info(b.toString()));
			}finally{
				em.close();
			}
	}
	
	public void getBookByDate(int date) {
			EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
			
			try {
				Query query = em.createNamedQuery("Book.findByDate");
				query.setParameter("book_data", date);
				List<Book> resultBook = query.getResultList();
				resultBook.forEach(b -> log.info(b.toString()));
			}finally{
				em.close();
			}
	}
	
	public void getBookByAuthor(String author) {
			EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
			
			try {
				Query query = em.createNamedQuery("Book.findByAuthor");
				query.setParameter("author_name", author);
				List<Book> resultBook = query.getResultList();
				resultBook.forEach(b -> log.info(b.toString()));
			}finally{
				em.close();
			}
	}
	
	public void getMagazineByTitle(String title) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			Query query = em.createNamedQuery("Magazine.findByTitle");
			query.setParameter("magazine_title", title);
			List<Magazine> resultBook = query.getResultList();
			resultBook.forEach(b -> log.info(b.toString()));
		}finally{
			em.close();
		}
}

	public void getMagazineByDate(int date) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			Query query = em.createNamedQuery("Magazine.findByDate");
			query.setParameter("magazine_data", date);
			List<Magazine> resultBook = query.getResultList();
			resultBook.forEach(b -> log.info(b.toString()));
		}finally{
			em.close();
		}
}
}
