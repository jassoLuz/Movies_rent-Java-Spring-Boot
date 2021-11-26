package com.univaProject.UnivaMovies.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Alquiler {
	@Id
	@SequenceGenerator(
			name = "alquiler_seq",
			sequenceName = "alquiler_seq",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "alquiler_seq"
			)
	
	private Long id;
	
	int dias;
	float costopordia;
	String formapago;
	Date fechaAlquiler;
	
    @ElementCollection(targetClass=Pelicula.class)
	@OneToMany(mappedBy = "id",cascade = CascadeType.ALL)
    private List<Pelicula> peliculas;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
    private Socio socio;
    

	public Alquiler() {
    	super();
    }
    
	public Alquiler(int dias, float costopordia, String formapago, Date fechaAlquiler, List<Pelicula> pelicula, Socio socio) {
		super();
		this.dias = dias;
		this.costopordia = costopordia;
		this.formapago = formapago;
		this.fechaAlquiler = fechaAlquiler;
		this.peliculas = pelicula;
		this.socio = socio;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}
	
	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> pelicula) {
		this.peliculas = pelicula;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	boolean CrearAlquiler() {
		return true;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public float getCostopordia() {
		return costopordia;
	}

	public void setCostopordia(float costopordia) {
		this.costopordia = costopordia;
	}

	public String getFormapago() {
		return formapago;
	}

	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}
	
}
