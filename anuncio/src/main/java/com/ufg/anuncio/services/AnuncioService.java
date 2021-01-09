package com.ufg.anuncio.services;

import java.util.List;
import java.util.Optional;

import com.ufg.anuncio.domain.Anuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ufg.anuncio.domain.AnuncioResponseDto;
import com.ufg.anuncio.repository.IAnuncioRepository;
import com.ufg.anuncio.repository.IComplementoRepository;
import com.ufg.anuncio.services.exceptions.AnuncioNaoEncontradoException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AnuncioService {
	
	public static final String AnuncioNaoEncontrado = "O Anúncio não pode ser encontrado!";
	
	@Autowired
	public IAnuncioRepository anunciosRepository;
	
	@Autowired
	private IComplementoRepository complementoRepository;

	public Page<Anuncio> buscarTodos(@PageableDefault Pageable pageable) {
		return anunciosRepository.findAll(pageable);
	}
	
	public Optional<Anuncio> buscarAnuncio(Long id) {
		Optional<Anuncio> anuncio = anunciosRepository.findById(id);
		anuncio.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found"));
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
	
//	public ComplementoAnuncio salvarComplemento(Long anuncioId, ComplementoAnuncio complemento) {
//		Optional<Anuncio> anuncio = buscarAnuncio(anuncioId);
//		complemento.setAnuncio(anuncio);
//
//		return complementoRepository.save(complemento);
//	}
	
	public List<Anuncio> buscarPorTitulo(String titulo){
		return anunciosRepository.findByTitle(titulo);
	}
	
	public String buscaComFiltros(AnuncioResponseDto dto, Pageable pageable) {
		return anunciosRepository.findAll(dto.toSpec(), pageable).getContent().toString();		
	}	
		
}
