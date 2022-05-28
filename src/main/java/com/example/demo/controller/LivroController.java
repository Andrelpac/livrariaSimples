package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Livro;
import com.example.demo.model.UpdateLivroDTO;
import com.example.demo.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	LivroService service;
	
	@GetMapping
	public List<Livro> getAll(@RequestParam(required = false) String ordem){
		return service.findAll(ordem);
	}
	
	@GetMapping("/{id}")
	public Livro getById(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@PostMapping
	public void create (@Valid @RequestBody Livro livro) {
		service.create(livro);
	}
	
	@PutMapping("/{id}")
	public Livro update(@PathVariable Integer id, @Valid @RequestBody UpdateLivroDTO livro) {
		return service.update(livro, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
