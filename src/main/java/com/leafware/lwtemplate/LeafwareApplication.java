package com.leafware.lwtemplate;

import com.leafware.lwtemplate.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class LeafwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeafwareApplication.class, args);
	}

}
