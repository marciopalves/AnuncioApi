package com.ufg.anuncio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufg.anuncio.domain.Anuncio;

public interface IAnuncioRepository extends JpaRepository<Anuncio, Long>{

}
