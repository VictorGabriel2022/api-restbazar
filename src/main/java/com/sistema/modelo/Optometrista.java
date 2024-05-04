package com.sistema.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "optometrista")
public class Optometrista implements Serializable  {

	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer optometristaid;	
	@Column
	private String nombre;	
	@Column
	private Integer telefono;	
	@Column
	private Integer dni;	
	@Column
	private String direccion;
	@Column
	private String horario;
	
	@OneToMany(mappedBy="optometrista")
	@JsonIgnore
	private Collection<Citas> itemsCitas=new ArrayList<>();

	
	public Optometrista() {
		
	}

	public Optometrista(Integer optometristaid, String nombre, Integer telefono, Integer dni, String direccion,
			String horario) {
		super();
		this.optometristaid = optometristaid;
		this.nombre = nombre;
		this.telefono = telefono;
		this.dni = dni;
		this.direccion = direccion;
		this.horario = horario;
	}



	public Integer getOptometristaid() {
		return optometristaid;
	}

	public void setOptometristaid(Integer optometristaid) {
		this.optometristaid = optometristaid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}	

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Collection<Citas> getItemsCitas() {
		return itemsCitas;
	}

	public void setItemsCitas(Collection<Citas> itemsCitas) {
			this.itemsCitas = itemsCitas;
	}

	
	
	
}
