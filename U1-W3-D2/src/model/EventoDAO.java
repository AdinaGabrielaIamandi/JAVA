package model;

import javax.persistence.EntityManager;

public class EventoDAO {
	
	static EntityManager em = JpaUtil.getEmf().createEntityManager();
	
	public static void save(Evento e) {
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("Evento inserito!!!");
		
	}
	
	public static Evento getById(Long i) {
		
		em.getTransaction().begin();
		Evento e = em.find(Evento.class, i);
		em.getTransaction().commit();
		return e;
		
	}
	
	public static void delete(Evento e) {
		
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Evento eliminato dal DB!");
		
	}
	
	public static void refresh(Evento e) {
		em.refresh(e);
	}
}
