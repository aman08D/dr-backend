package com.dr.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.dr.backend.model.User;
import com.dr.backend.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	// Server chalu hote hi 1 Admin DB me ban jayega:
	@Bean
	public CommandLineRunner initAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (!userRepository.existsByEmail("admin@dr.com")) {
				User admin = new User();
				admin.setEmail("admin@dr.com");
				admin.setPassword(passwordEncoder.encode("admin123")); // Default password: admin123
				userRepository.save(admin);
				System.out.println("✅ SUPER ADMIN CREATED: admin@dr.com / admin123");
			}
		};
	}



}
