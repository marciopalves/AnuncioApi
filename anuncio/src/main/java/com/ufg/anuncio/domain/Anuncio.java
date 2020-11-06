package com.ufg.anuncio.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Anuncio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	
	private String local;
	
	private Calendar data;
	
	private String descricao;
	
	@Transient
	private ComplementoAnuncio complemento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ComplementoAnuncio getComplemento() {
		return complemento;
	}

	public void setComplemento(ComplementoAnuncio complemento) {
		this.complemento = complemento;
	}
	
	public Anuncio() {
		
	}
	
	public Anuncio(String titulo, String local, String descricao) {		
		this.titulo = titulo;
		this.local = local;
		this.descricao = descricao;
		this.data = Calendar.getInstance();
	}
	
	public Anuncio( String titulo, String local, String descricao, Calendar data ) {
		this.titulo = titulo;
		this.local = local;
		this.descricao = descricao;
		this.data = data;
	}
	
}
