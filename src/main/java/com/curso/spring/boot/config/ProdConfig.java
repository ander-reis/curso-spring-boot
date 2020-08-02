package com.curso.spring.boot.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.spring.boot.services.DBService;
import com.curso.spring.boot.services.EmailService;
import com.curso.spring.boot.services.SmtpEmailService;

@Configuration
@Profile("prod")
public class ProdConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDatabase( ) throws ParseException {

		if(!"create".equals(strategy)) {
			return false;			
		}

		dbService.instantiateDatabase();

		return true;
	}

	// instancia email service para enviar email de teste
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
