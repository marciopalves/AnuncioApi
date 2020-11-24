package com.ufg.anuncio.resources;

import 	java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ufg.anuncio.domain.Anuncio;
import com.ufg.anuncio.domain.AnuncioResponseDto;
import com.ufg.anuncio.domain.ComplementoAnuncio;
import com.ufg.anuncio.services.AnuncioService;

@RestController
@RequestMapping("/anuncios")
public class AnuncioResources {
	
	@Autowired
	public AnuncioService  anuncioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String buscarTodos(Pageable pageable) {
		return anuncioService.buscarTodos(pageable);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Anuncio anuncio) {
		
		anuncio = anuncioService.salvar(anuncio);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(anuncio.getId()).toUri();		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		
		Optional<Anuncio> anuncio = anuncioService.buscarAnuncio(id);
		return ResponseEntity.ok(anuncio);	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		
		anuncioService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Anuncio anuncio, @PathVariable("id") Long id) {
		
		anuncioService.atualizar(anuncio);
		return ResponseEntity.noContent().build();
	}
	
//	@RequestMapping(value = "{id}/complementos", method = RequestMethod.POST)
//	public ResponseEntity<Void> adcionarComplemento(@PathVariable("id") Long anuncioId, 
//				@RequestBody ComplementoAnuncio complemento) {
//		
//		anuncioService.salvarComplemento(anuncioId, complemento);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
//		
//		return ResponseEntity.created(uri).build();
//		
//	}
	
	@RequestMapping(value = "/filtros", method = RequestMethod.GET)
	public String buscaComFiltros(AnuncioResponseDto dto, Pageable pageable) {				
		return anuncioService.buscaComFiltros(dto, pageable);
	}
	
}
