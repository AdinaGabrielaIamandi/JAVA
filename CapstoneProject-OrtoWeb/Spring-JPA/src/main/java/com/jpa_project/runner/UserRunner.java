package com.jpa_project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.jpa_project.service.UserService;

@Component
public class UserRunner implements ApplicationRunner{
	
	@Autowired
	UserService userService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
		userService.createFakeUser();
		
	}

}
