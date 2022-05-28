package com.example.demo.model;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class UpdateLivroDTO {

	@Size(min = 4, max = 40)
	public String autor;

	@Size(min = 3, max = 20)
	public String tipo;

	@Size(min = 5, max = 30)
	private String titulo;

	@Past
	private LocalDate dataPublicacao;

	public UpdateLivroDTO() {
		super();
	}

	public UpdateLivroDTO(@Size(min = 4, max = 40) String autor, @Size(min = 3, max = 20) String tipo,
			@Size(min = 5, max = 30) String titulo, @Past LocalDate dataPublicacao) {
		super();
		this.autor = autor;
		this.tipo = tipo;
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

}
