package com.rest_project.configuration;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.github.javafaker.Faker;
import com.rest_project.model.User;

@Configuration
public class UserConfiguration {

	@Value("${user.admin.name}")
	private String adminName;
	@Value("${user.admin.lastname}")
	private String adminLastame;
	@Value("${user.admin.email}")
	private String adminEmail;
	@Value("${user.admin.age}")
	private Integer adminAge;
	@Value("${user.admin.city}")
	private String adminCity;
	@Value("${user.admin.password}")
	private String adminPassword;

	@Bean("AdminUserBean")
	@Scope("singleton")
	public User newAdimnUser() {
		return User.builder().name(adminName).lastname(adminLastame).email(adminEmail).age(adminAge).city(adminCity)
				.password(adminPassword).build();
	}

	@Bean("FakeUser")
	@Scope("prototype")
	public User fakeUser() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		User u = new User();
		u.setName(fake.name().firstName());
		u.setLastname(fake.name().lastName());
		u.setAge(fake.number().numberBetween(16, 80));
		u.setEmail(u.getName() + "." + u.getLastname() + "@example.com");
		u.setPassword(fake.internet().password(6, 10, true, true));
		u.setCity(fake.address().city());
		return u;
	}

	@Bean("CostumUser")
	@Scope("prototype")
	public User costumUser() {
		return new User();
	}

}
