package com.univaProject.UnivaMovies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Pelicula {
	
	@Id
	@SequenceGenerator(
			name = "pelicula_seq",
			sequenceName = "pelicula_seq",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "pelicula_seq"
			)
	
	private Long id;
	
	private String titulo;
	private int año;
	private String duracion;
	private String sinopsis;
	private String productor;
	private String clasificacion;
	private String genero;
	private int copias;
	
	@Transient
	private String clave;	
	
	public String getClave() {
		this.clave = this.getId() + this.getAño() + this.getClasificacion() + this.getCopias(); 
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Pelicula() {
		super();
	}

	public Pelicula(String titulo, int año, String duracion, String sinopsis, String productor, String clasificacion,
			String genero, int copias) {
		super();
		this.titulo = titulo;
		this.año = año;
		this.duracion = duracion;
		this.sinopsis = sinopsis;
		this.productor = productor;
		this.clasificacion = clasificacion;
		this.genero = genero;
		this.copias = copias;
	}

	boolean obtenerPelicula() {
		return true;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public int getCopias() {
		return copias;
	}

	public void setCopias(int copias) {
		this.copias = copias;
	}

}
