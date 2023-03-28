package com.epicode.mainproject;

import java.sql.SQLException;
import java.util.List;
import com.epicode.connector.DBConnection;
import com.epicode.model.User;

public class GestioneDb {
	
	public static void main(String[] args) {
		
		try {
			DBConnection db = new DBConnection();
			
			//AGGIUNGI UTENTE AL DB
			//User utente1 = new User("Mario", "Rossi", 25, "m.rossi@example.com");
			//User utente1 = new User("Giuseppe", "Verdi", 44, "g.verdi@example.com");
			//User utente1 = new User("Francesca", "Neri", 30, "f.neri@example.com");
			//db.createUsers(utente1);
			
			//LEGGI UN UTENTE DAL DB
			//User utenteDaLeggere = db.findUser(1);
			//System.out.println(utenteDaLeggere);
			
			//MODIFICA UN UTENTE DEL DB
			/*utenteDaLeggere.setAnni(44);
			db.updateUser(utenteDaLeggere);*/
			
			//ELIMINA UN UTENTE DAL DB
			/*db.deleteUser(utenteDaLeggere);*/
			
			List<User> userList = db.findAllUsers();
			userList.forEach(u -> System.out.println(u));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
