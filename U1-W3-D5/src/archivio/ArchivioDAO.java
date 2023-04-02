package archivio;

import javax.persistence.EntityManager;
import JPA_util.JpaUtil;
import model.Libro;
import model.Rivista;

public class ArchivioDAO {
	
	static EntityManager em = JpaUtil.getEmf().createEntityManager();
	
	public static void aggiungiLibro(Libro l) {
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		System.out.println("Elemento aggiunto al catalogo!!!");
	}
	
	public static void aggiungiRivista(Rivista r) {
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		System.out.println("Elemento aggiunto al catalogo!!!");
	}

}
