

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.app.utils.JpaUtil;

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
}
