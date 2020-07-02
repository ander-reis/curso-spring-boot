package com.curso.spring.boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.boot.domain.Estado;
import com.curso.spring.boot.repositories.EstadoRepository;

@Service
public class EstadoService extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> findAll() {
		return repo.findAllByOrderByNome();
	}
}
