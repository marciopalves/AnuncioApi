package com.ufg.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ufg.anuncio.domain.DetalhesErro;
import com.ufg.anuncio.services.exceptions.AnuncioNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler{
	
	@ExceptionHandler(AnuncioNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleAnuncioNaoEncontradoException(AnuncioNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Anúncio não encontrado");
		erro.setMensagemDesenvolvedor("htttp//erros.anuncio.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida");
		erro.setMensagemDesenvolvedor("htttp//erros.anuncio.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
}
