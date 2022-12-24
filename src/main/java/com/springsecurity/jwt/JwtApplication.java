package com.springsecurity.jwt;

import com.springsecurity.jwt.model.Role;
import com.springsecurity.jwt.model.User;
import com.springsecurity.jwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
		System.out.println("Serverside is Running....");
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"Fuad maruk","fuad","1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Ricky Rizal ","ricky","1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Ferdy Sambo","sambo","1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Richard Eliezer","richard","1234", new ArrayList<>()));

			userService.addRoleToUser("fuad","ROLE_USER");
			userService.addRoleToUser("richard","ROLE_MANAGER");
			userService.addRoleToUser("richard","ROLE_ADMIN");
			userService.addRoleToUser("ricky","ROLE_MANAGER");
			userService.addRoleToUser("sambo","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("sambo","ROLE_ADMIN");
			userService.addRoleToUser("sambo","ROLE_USER");
		};
	}

}
