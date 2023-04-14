package com.jpa_project.configuration;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import com.github.javafaker.Faker;
import com.jpa_project.model.User;

@Configuration
@PropertySource("classpath:application.properties")
public class UserConfiguration {

	@Value("${user.admin.name}")
	private String adminName;
	@Value("${user.admin.lastname}")
	private String adminLastame;
	@Value("${user.admin.email}")
	private String adminEmail;
	@Value("${user.admin.age}")
	private int adminAge;
	@Value("${user.admin.city}")
	private String adminCity;
	@Value("${user.admin.password}")
	private String adminPassword;

	@Bean("AdminUser")
	@Scope("singleton")
	public User adminUser() {
		return new User(null, adminName, adminLastame, adminEmail, adminAge, adminCity, adminPassword);
	}

	@Bean("CostumUser")
	@Scope("prototype")
	public User costumUser() {
		return new User();
	}

	@Bean("ParamsUser")
	@Scope("prototype")
	public User paramsUser(String name, String lastname, String email, Integer age, String city, String password) {
		return new User(null, name, lastname, email, age, city, password);
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

}
