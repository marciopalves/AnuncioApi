package com.ufg.anuncio.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;


@Entity
public class Anuncio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotNull(message = "O campo título não pode ser vazio.")
	private String titulo;
	
	//@NotNull(message = "O campo local não pode ser vazio.")
	private String local;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	private String descricao;
	
	@OneToOne(mappedBy = "anuncio")
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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
		this.data = new Date();
	}
	
	public Anuncio( String titulo, String local, String descricao, Date data ) {
		this.titulo = titulo;
		this.local = local;
		this.descricao = descricao;
		this.data = data;
	}			
}
