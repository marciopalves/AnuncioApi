package com.ufg.anuncio.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ComplementoAnuncio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Number id;
	
	private String texto;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ANUNCIO_ID")
	@JsonIgnore
	private Anuncio anuncio;

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	
}
