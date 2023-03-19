package com.app.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.app.travel.models"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
