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

	/**
	 * Executes Flyway database migrations after the JPA initialization.
	 *
	 * @param flyway The Flyway instance used to perform the database migrations.
	 * @return A CommandLineRunner that triggers the Flyway migrations.
	 */
	@Bean
	@Order(Integer.MIN_VALUE)
	public CommandLineRunner flywayMigrate( Flyway flyway ) {
		return args -> {
			// Executa as migrações do Flyway após a inicialização do JPA
			flyway.migrate();
		};
	}

}
