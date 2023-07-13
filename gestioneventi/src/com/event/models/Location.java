package com.event.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "città", nullable = false)
	private String città;

	public Location() {
		super();
	}

	public Location(String nome, String città) {
		super();
		this.nome = nome;
		this.città = città;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", nome=" + nome + ", città=" + città + "]";
	}
	
	
}
