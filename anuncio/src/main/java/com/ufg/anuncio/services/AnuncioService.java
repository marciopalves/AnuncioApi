package com.ufg.anuncio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ufg.anuncio.domain.Anuncio;
import com.ufg.anuncio.domain.ComplementoAnuncio;
import com.ufg.anuncio.repository.IAnuncioRepository;
import com.ufg.anuncio.repository.IComplementoRepository;
import com.ufg.anuncio.services.exceptions.AnuncioNaoEncontradoException;

@Service
public class AnuncioService {
	
	public static final String AnuncioNaoEncontrado = "O Anúncio não pode ser encontrado!";
	
	@Autowired
	public IAnuncioRepository anunciosRepository;
	
	@Autowired
	private IComplementoRepository complementoRepository;

	public List<Anuncio> listar(){
		return anunciosRepository.findAll();
	}
	
	public Anuncio buscarAnuncio(Long id) {
		Anuncio anuncio = anunciosRepository.getOne(id);
		
		if (anuncio == null){
			throw new AnuncioNaoEncontradoException(AnuncioNaoEncontrado);
		}
		return anuncio;
	}
	
	public Anuncio salvar(Anuncio anuncio) {
		anuncio.setId(null);
		anuncio = anunciosRepository.save(anuncio);
		
		return anuncio;
	}
	
	public void deletar(Long id) {
		
		try {
			anunciosRepository.deleteById(id);			
		}catch(EmptyResultDataAccessException e) {
			throw new AnuncioNaoEncontradoException(AnuncioNaoEncontrado);
		}
	}
	
	public void atualizar(Anuncio anuncio) {
		verificarExistencia(anuncio);
		anunciosRepository.save(anuncio);
	}
	
	public void verificarExistencia(Anuncio anuncio) {
		buscarAnuncio(anuncio.getId());
	}
	
	public ComplementoAnuncio salvarComplemento(Long anuncioId, ComplementoAnuncio complemento) {
		Anuncio anuncio = buscarAnuncio(anuncioId);
		complemento.setAnuncio(anuncio);

		return complementoRepository.save(complemento);
	}
	
	public List<Anuncio> BuscarPorTitulo(String titulo){
		return anunciosRepository.findByTitle(titulo);
	}
	
	public List<Anuncio> BuscarPorLocal(String local){
		return anunciosRepository.findByLocal(local);
	}
}
