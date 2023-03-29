package controler;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.User;

public class MainProject {
	
	static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("U1-W3-D2-JPA-PROJECT");
	//persistenceUnitName the name of the persistence unit da passare come parametro
	//DriverMaganer.getConnection() in JDBC
	
	static EntityManager em = emf.createEntityManager();
	//oggetto che servirà per connettersi con il db

	public static void main(String[] args) {
		
		User u = new User();
		u.setName("Fiona");
		u.setLastname("Verdi");
		u.setEmail("f.verdi@example.com");
		
		
		try {
			
			//addUser(u);
			//User utenteDaLeggere = findUser(2L);
			//System.out.println(utenteDaLeggere);
			
			//utenteDaLeggere.setEmail("test@example.com");
			//updateUser(utenteDaLeggere);
			
			//removeUser(utenteDaLeggere);
			
			List<User> listaUtenti = findAllUsers();
			listaUtenti.forEach(ut -> System.out.println(ut));
			
		} catch (Exception e) {
			
			// TODO: handle exception
			
		} finally {
			
			em.close();
			emf.close();
			
		}
		

	}
	
	public static void addUser(User u) {
		//il vecchio INSERT INTO in SQL/JDBC
		
		//vai a leggere la transizione esistente
		em.getTransaction().begin();
		
		//salva l'oggetto
		em.persist(u);
		
		//esegui l'operazione
		em.getTransaction().commit();
		
		System.out.println("Utente salvato nel DB!");
		
	}
	
	public static User findUser(Long id) {
		//il vecchio SELECT * FROM WHERE id_user=id(parametro)
		
		em.getTransaction().begin();
		User u = em.find(User.class, id);
		em.getTransaction().commit();
		return u;
	}
	
	public static void updateUser(User u) {
		//il vecchio UPDATE della tabella
		
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		System.out.println("Utente modificato");
		
	}
	
	public static void removeUser(User u) {
		//il vecchio DELETE della tabella
		
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		System.out.println("Utente eliminato dal DB!");
		
	}
	
	public static List<User> findAllUsers() {
		
		Query q = em.createNamedQuery("User.findAll");
		return q.getResultList();
		
	}

}
