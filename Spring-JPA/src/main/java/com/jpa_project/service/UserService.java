package com.jpa_project.service;

import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.jpa_project.model.User;
import com.jpa_project.repository.UserDaoRepository;

@Service
public class UserService {

	@Autowired
	UserDaoRepository repo;

	@Autowired
	@Qualifier("FakeUser")
	private ObjectProvider<User> fakeUserProvider;

	@Autowired
	@Qualifier("AdminUser")
	private ObjectProvider<User> adminUserProvider;

	public void createFakeUser() {
		insertUser(fakeUserProvider.getObject());
	}

	public void createAdminUser() {
		insertUser(adminUserProvider.getObject());
	}

//	JPA METHOD

	public void insertUser(User u) {
		repo.save(u);
	}

	public User findUserByID(Long id) {
		return repo.findById(id).get();
	}

	public List<User> findAllUsers() {
		return (List<User>) repo.findAll();
	}

	public void removeUser(Long id) {
		repo.deleteById(id);
	}

	public void UpdateUser(User u) {
		repo.save(u);
	}

}
