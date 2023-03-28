package com.epicode.mainproject;

import java.sql.SQLException;
import com.epicode.connector.DBConnection;
import com.epicode.model.Student;

public class GestioneDb {
	
	public static void main(String[] args) {
		
		try {	
			DBConnection db = new DBConnection();
			//Student s = new Student("Fiona", "Verdi", "f", "15/02/1980", 4d, 8d);
			//db.insertStudent(s);
			
			Student s = db.findStudent(3);
			s.setMax_vote(10d);
			db.updateStudent(s);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
