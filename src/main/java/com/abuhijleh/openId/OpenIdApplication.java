package com.abuhijleh.openId;

import com.abuhijleh.openId.repo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class OpenIdApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenIdApplication.class, args);
	}

}
