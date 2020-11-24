package com.ufg.anuncio.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
	@JsonIgnore
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anuncio other = (Anuncio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	public String toString() {		
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		
		return "id:"+this.id +
			   " titulo:"+this.titulo+
			   " data:"+f.format(this.data);
	}
	
}
