package com.jdbc_project.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.jdbc_project.model.User;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserJDBCDao implements UserDaoRepository {

	@Autowired
	JdbcTemplate jdbc;

//	public UserJDBCDao() {
//		this.jdbc = new JdbcTemplate();
//	}

	@Override
	public void create(User user) {
		String sql = "INSERT INTO users (name, lastname, email, age, city, password) " + "VALUES (?, ?, ?, ? ,?, ?)";
		jdbc.update(sql, user.getName(), user.getLastname(), user.getEmail(), user.getAge(), user.getCity(),
				user.getPassword());
		log.info("Utente " + user.getName() + " " + user.getLastname() + ", user salvato nel DB");
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE users SET name = ?, lastname = ?, email = ?, age = ?, city = ?, password = ? WHERE id = ?";
		jdbc.update(sql, user.getName(), user.getLastname(), user.getEmail(), user.getAge(), user.getCity(),
				user.getPassword(), user.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM users WHERE id = ?";
		jdbc.update(sql, id);
		log.info("Utente cancellato dal DB!!");
	}

	@Override
	public User getById(Long id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		User u = jdbc.queryForObject(sql, new UserRowMapper(), id);
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM users";
		List<User> list = jdbc.query(sql, new UserRowMapper());
		return list;
	}

}
