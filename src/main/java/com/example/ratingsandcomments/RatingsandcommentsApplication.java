package com.example.ratingsandcomments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan
@EnableMongoRepositories
@SpringBootApplication

public class RatingsandcommentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingsandcommentsApplication.class, args);
	}

}
