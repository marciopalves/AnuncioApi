package com.ufg.anuncio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufg.anuncio.domain.ComplementoAnuncio;

public interface IComplementoRepository extends JpaRepository<ComplementoAnuncio , Long> {

}
