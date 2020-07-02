package com.curso.spring.boot.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.curso.spring.boot.domain.Cliente;
import com.curso.spring.boot.domain.Pedido;

public interface EmailService {
	
	// envio de email plano
	void sendOrderConfirmationEmail(Pedido obj);
	
	// envio de email plano
	void sendEmail(SimpleMailMessage msg);

	// envio de email html
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	// envio de email html
	void sendHtmlEmail(MimeMessage msg);
	
	// envio de email nova senha
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
