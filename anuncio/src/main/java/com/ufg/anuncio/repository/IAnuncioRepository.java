package com.ufg.anuncio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.ufg.anuncio.domain.Anuncio;

public interface IAnuncioRepository extends PagingAndSortingRepository<Anuncio, Long>, 
											JpaSpecificationExecutor<Anuncio>{
	
	@Query("select a from Anuncio a where a.titulo like %:title%")
	List<Anuncio> findByTitle(@Param("title") String titulo);
	
	@Query("select a from Anuncio a where a.local like %:local%")
	List<Anuncio> findByLocal(@Param("local") String local);
	

}
