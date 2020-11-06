package com.ufg.anuncio.services.exceptions;

public class AnuncioNaoEncontradoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5620995134267734815L;

	public AnuncioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AnuncioNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
