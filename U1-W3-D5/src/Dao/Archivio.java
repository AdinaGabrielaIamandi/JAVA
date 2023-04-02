package Dao;

import javax.persistence.EntityManager;
import JPA_util.JpaUtil;
import model.Elemento_Catalogo;
import model.Libro;
import model.Rivista;

public class Archivio {
	
	static EntityManager em = JpaUtil.getEmf().createEntityManager();
	
	public static void aggiungiLibro(Libro l) {
		try {
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		System.out.println("Aggiunto");
		} catch (Exception e){
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public static void aggiungiRivista(Rivista r) {
		try {
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		System.out.println("Aggiunto");
		} catch (Exception e){
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public static void rimuoviElemento(Elemento_Catalogo el) {
		try {
		em.getTransaction().begin();
		em.remove(el);
		em.getTransaction().commit();
		System.out.println("Rimosso");
		} catch (Exception e){
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	@SuppressWarnings("finally")
	public static Elemento_Catalogo trovaElementoISBN(Long i) {
		Elemento_Catalogo el = null;
		try {
			em.getTransaction().begin();
			el = em.find(Elemento_Catalogo.class, i);
			em.getTransaction();
		} catch (Exception e){
			em.getTransaction().rollback();
		} finally {
			em.close();
			return el;
		}
	}

}
