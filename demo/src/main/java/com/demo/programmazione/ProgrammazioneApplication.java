package com.demo.programmazione;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication //(scanBasePackages = {"com.demo"})
@EnableJpaRepositories //(basePackages = "com.demo.repository")
@EntityScan //(basePackages = "com.demo.model")
public class ProgrammazioneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammazioneApplication.class, args);
	}

}
