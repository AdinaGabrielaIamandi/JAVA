package com.jdbc_project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jdbc_project.model.User;
import com.jdbc_project.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserRunner implements CommandLineRunner {
	
	@Autowired
	UserService userService;

	@Override
	public void run(String... args) throws Exception {
		log.info("Run... UserRunner");
		//userService.createFakeUser();
		//userService.createAdminUser();
		//User u = userService.findUserByID(2l);
		//u.setPassword("$$$$$$$$$$");
		//userService.UpdateUser(u);
		//log.info(u.toString());
		//userService.removeUser(2l);
		userService.findAllUsers().forEach(u -> System.out.println(u));
		
	}



}
