package com.epicode.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epicode.model.User;

public class DBConnection {
	
	private String url = "jdbc:postgresql://localhost:5432/";
	private String dbName = "JDBC_Java";
	private String userName = "postgres";
	private String password = "Adina!Epic2023";
	Statement st;
	
	public DBConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url+dbName, userName, password);
		st = conn.createStatement();
		createTabUser();
	}
	
	public void createTabUser() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS Users("
				+ "id_user SERIAL PRIMARY KEY,"
				+ "nome VARCHAR NOT NULL,"
				+ "cognome VARCHAR NOT NULL," 
				+ "anni INTEGER NOT NULL,"
				+ "email VARCHAR NOT NULL UNIQUE)";
		this.st.executeUpdate(sql);
	}
	
	public void createUsers(User u) throws SQLException {
		String sql = "INSERT INTO Users (nome, cognome, anni, email) "
                + "VALUES ('" + u.getNome() + "', '" + u.getCognome() + "', " + u.getAnni() + ", '" + u.getEmail() + "')";
		this.st.executeUpdate(sql);
		System.out.println("Utente salvato!");
	}
	
	public User findUser(Integer id) throws SQLException {
		User utente = null;
		String sql = "SELECT *FROM Users WHERE id_user = " + id;
		ResultSet rs = this.st.executeQuery(sql);
		if(rs.next()) {
			Long id_user = rs.getLong("id_user");
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			int anni = rs.getInt("anni");
			String email = rs.getString("email");
			utente = new User(id_user, nome, cognome, anni, email);
		}
		return utente;
	}
	
	public void updateUser(User u) throws SQLException {
		String sql = "UPDATE Users "
				+ "SET nome = '" + u.getNome() + "', cognome = '" + u.getCognome() + "', anni = " + u.getAnni() + ", email = '" + u.getEmail() + "'"
				+ "WHERE id_user = " + u.getId();
		this.st.executeUpdate(sql);
	}
	
	public void deleteUser(User u) throws SQLException {
		String sql = "DELETE FROM Users WHERE id_user = " + u.getId();
		this.st.executeUpdate(sql);System.out.println("Utente eliminato!");
	}
	
	public List<User> findAllUsers() throws SQLException {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM Users";
		ResultSet rs = this.st.executeQuery(sql);
		while(rs.next()) {
			Long id_user = rs.getLong("id_user");
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			int anni = rs.getInt("anni");
			String email = rs.getString("email");
			User utente = new User(id_user, nome, cognome, anni, email);
			users.add(utente);
		}
		return users;
	}
}
