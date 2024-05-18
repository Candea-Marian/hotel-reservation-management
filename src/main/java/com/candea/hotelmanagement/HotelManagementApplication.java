package com.candea.hotelmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.candea.hotelmanagement.dao.UserDao;
import com.candea.hotelmanagement.entity.User;

@SpringBootApplication
public class HotelManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserDao users, PasswordEncoder encoder) {
		return args -> {
			//users.save(new User("user", encoder.encode("password"),"candea.dev@gmail.com","USER"));
			//users.save(new User("admin",encoder.encode("password"), "caca","USER,ADMIN"));

		};
	}

}
