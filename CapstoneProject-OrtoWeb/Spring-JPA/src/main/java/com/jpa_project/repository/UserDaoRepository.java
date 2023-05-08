package com.jpa_project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jpa_project.model.User;

@Repository
public interface UserDaoRepository extends CrudRepository<User, Long> {
	
	

}
