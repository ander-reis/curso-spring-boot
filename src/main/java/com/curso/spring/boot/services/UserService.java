package com.curso.spring.boot.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.curso.spring.boot.security.UserSS;

public class UserService {

	/**
	 * retorna usuário logado
	 * @return
	 */
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	};
}
