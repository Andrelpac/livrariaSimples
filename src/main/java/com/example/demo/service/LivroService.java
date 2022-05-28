package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Livro;
import com.example.demo.model.UpdateLivroDTO;
import com.example.demo.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository repository;

	public List<Livro> findAll(String ordem) {
		if (ordem == null) {
			return repository.findAll();
		}
		Sort sort = Sort.by(ordem);
		return repository.findAll(sort);
	}

	public Livro findById(Integer id) {
		Optional<Livro> optional = repository.findById(id);
		if (optional.isEmpty()) {
			System.out.println("deu erro");
			return null;
		}
		return optional.get();
	}

	public void create(Livro livro) {
		repository.save(livro);
	}

	public Livro update(UpdateLivroDTO novoLivro, Integer id) {
		Livro oldLivro = this.findById(id);
		if (novoLivro.getTipo() != null) {
			oldLivro.setTipo(novoLivro.getTipo());
		}
		if (novoLivro.getAutor() != null) {
			oldLivro.setAutor(novoLivro.getAutor());
		}
		if (novoLivro.getTitulo() != null) {
			oldLivro.setTitulo(novoLivro.getTitulo());
		}
		if (novoLivro.getDataPublicacao() != null) {
			oldLivro.setDataPublicacao(novoLivro.getDataPublicacao());
		}
		return repository.save(oldLivro);
	}

	public void delete(Integer id) {
		Livro livro = this.findById(id);
		repository.delete(livro);
	}

}
