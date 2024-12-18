package com.ms.email;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class EmailSenderApplication {

	public static void main( String[] args ) {
		SpringApplication.run(EmailSenderApplication.class, args);
	}

}
