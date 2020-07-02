package com.curso.spring.boot.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.spring.boot.services.DBService;
import com.curso.spring.boot.services.EmailService;
import com.curso.spring.boot.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	// instancia dbService para fazer insert data no banco de dados
	@Bean
	public boolean instantiateDatabase( ) throws ParseException {
		dbService.instantiateDatabase();
		return true;
	}
	
	// instancia email service para enviar email de teste
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
