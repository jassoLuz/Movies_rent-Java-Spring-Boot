package com.univaProject.UnivaMovies.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPeliculaRepository extends JpaRepository<Pelicula, Long>{
	
	@Query("SELECT p FROM Pelicula p WHERE titulo = ?1" )
	/*Optional<Pelicula> findByName(String name);*/	
	Optional<Pelicula> findByName(String name);
}
