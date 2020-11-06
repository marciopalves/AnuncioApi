package com.ufg.anuncio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufg.anuncio.domain.Anuncio;
import com.ufg.anuncio.repository.IAnuncioRepository;
import com.ufg.anuncio.services.exceptions.AnuncioNaoEncontradoException;

@Service
public class AnuncioService {
	
	public static final String AnuncioNaoEncontrado = "O Anúncio não pode ser encontrado!";
	
	@Autowired
	public IAnuncioRepository repository;

	public List<Anuncio> listar(){
		return repository.findAll();
	}
	
	public Anuncio buscar(Long id) {
		Anuncio anuncio = repository.getOne(id);
		
		if (anuncio == null){
			throw new AnuncioNaoEncontradoException(AnuncioNaoEncontrado);
		}
		return anuncio;
	}
	
	public Anuncio salvar(Anuncio anuncio) {
		anuncio.setId(null);
		anuncio = repository.save(anuncio);
		
		return anuncio;
	}
	
	public void deletar(Long id) {
		
		try {
			repository.deleteById(id);			
		}catch(EmptyResultDataAccessException e) {
			throw new AnuncioNaoEncontradoException(AnuncioNaoEncontrado);
		}
	}
	
	public void atualizar(Anuncio anuncio) {
		buscar(anuncio.getId());
		repository.save(anuncio);
	}
	

}
