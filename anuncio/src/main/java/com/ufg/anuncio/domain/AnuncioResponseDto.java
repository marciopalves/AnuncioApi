package com.ufg.anuncio.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class AnuncioResponseDto {
	
	private Long id;
	private String titulo;
	private String local;
	
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
	
	public Specification<Anuncio> toSpec(){
		return (root, query, builder) ->{
			
			List<Predicate> predicados	= new ArrayList();
			
			if(StringUtils.hasText(titulo)) {
				Path<String> campoId = root.<String>get("id");
				Predicate predicadoId =  builder.equal(campoId, id);
				predicados.add(predicadoId);
			}
			
			if(StringUtils.hasText(titulo)) {
				Path<String> campoTitulo = root.<String>get("titulo");
				Predicate predicadoTitulo = builder.like(campoTitulo, "%"+titulo+"%");
				predicados.add(predicadoTitulo);
			}
			
			if(StringUtils.hasText(local)) {
				Path<String> campoLocal = root.<String>get("local");
				Predicate predicadoLocal = builder.like(campoLocal, "%"+local+"%");
				predicados.add(predicadoLocal);
			}
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}

}
