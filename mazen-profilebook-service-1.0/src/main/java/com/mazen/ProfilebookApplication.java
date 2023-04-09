package com.mazen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.mazen")
@ComponentScan(basePackages = {"com.mazen"})
public class ProfilebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilebookApplication.class, args);
	}

}
