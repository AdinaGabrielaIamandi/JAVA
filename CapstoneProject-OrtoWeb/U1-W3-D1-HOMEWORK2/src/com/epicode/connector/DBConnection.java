package com.epicode.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.epicode.model.Student;

public class DBConnection {
	
	private String url = "jdbc:postgresql://localhost:5432/";
	private String dbName = "JDBC_Java_Homework";
	private String userName = "postgres";
	private String password = "Adina!Epic2023";
	Statement st;
	
	public DBConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url + dbName, userName, password);
		st = conn.createStatement();
		createTable();
	}
	
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS school_students("
				+ "id_student SERIAL PRIMARY KEY,"
				+ "name VARCHAR NOT NULL,"
				+ "lastname VARCHAR NOT NULL,"
				+ "gender VARCHAR NOT NULL,"
				+ "birthdate DATE NOT NULL,"
				+ "avg DECIMAL DEFAULT 0,"
				+ "min_vote DECIMAL NOT NULL,"
				+ "max_vote DECIMAL NOT NULL)";
		this.st.executeUpdate(sql);
	}
	
	public void insertStudent(Student s) throws SQLException {
		s.setAvg(s);
		String sql = "INSERT INTO school_students (name, lastname, gender, birthdate, avg, min_vote, max_vote)"
				+ "VALUES ('" + s.getName() + "', '" + s.getLastname() + "', '" + s.getGender() + "', '" +
				s.getBirthdate() + "', " + s.getAvg() + ", " + s.getMin_vote() 
				+ ", " + s.getMax_vote() + ")";
		this.st.executeUpdate(sql);
		System.out.println("Studente inserito!");
	}
	
	public Student findStudent(Integer id) throws SQLException {
		Student s = null;
		String sql = "SELECT * FROM school_students WHERE id_student = " +id;
		ResultSet rs = this.st.executeQuery(sql);
		if(rs.next()) {
			Long id_student = rs.getLong("id_student");
			String name = rs.getString("name");
			String lastname = rs.getString("lastname");
			String gender = rs.getString("gender");
			String birthdate = rs.getString("birthdate");
			Double avg = rs.getDouble("avg");
			Double min_vote = rs.getDouble("min_vote");
			Double max_vote = rs.getDouble("max_vote");
			s = new Student(id_student, name, lastname, gender, birthdate, avg, min_vote, max_vote);
		}
		return s;
	}
	
	public void updateStudent(Student s) throws SQLException {
		String sql = "UPDATE school_students "
				+ "SET name = '" + s.getName() + "', " 
				+ "lastname = '" + s.getLastname() + "', "
				+ "gender = '" + s.getGender() + "', "
				+ "birthdate = '" + s.getBirthdate() + "', "
				+ "min_vote = " + s.getMin_vote() + ", "
				+ "max_vote = " + s.getMax_vote() + " "
				+ "WHERE id_student = " + s.getId();
		this.st.executeUpdate(sql);
	}
	
	

}
