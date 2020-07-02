package com.curso.spring.boot.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.curso.spring.boot.domain.Categoria;
import com.curso.spring.boot.domain.Produto;
import com.curso.spring.boot.repositories.CategoriaRepository;
import com.curso.spring.boot.repositories.ProdutoRepository;
import com.curso.spring.boot.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	// busca produto por id
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	// busca produto ... com paginate
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		// paginacao
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		// lista categorias
		List<Categoria> categorias = categoriaRepository.findAllById(ids);

		// implementacao metodo search
		// return repo.search(nome, categorias, pageRequest);
		
		// implementacao metodo buscar produto
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
}
