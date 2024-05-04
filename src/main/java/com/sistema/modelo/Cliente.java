package com.sistema.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clienteid;
	@Column
	private String Nombre;
	@Column
	private String Apellido;
	@DateTimeFormat(pattern="dd/MM/yyyy",iso=ISO.DATE)
	private LocalDate FechaNacimiento;
	@Column
	private Integer Dni;

	public Cliente() {	}
	
	public Cliente(Integer clienteid, String nombre, String apellido, LocalDate fechaNacimiento, Integer dni,
			Usuario usuario) {
		this.clienteid = clienteid;
		Nombre = nombre;
		Apellido = apellido;
		FechaNacimiento = fechaNacimiento;
		Dni = dni;
		this.usuario = usuario;
	}

	@OneToOne(mappedBy = "cliente")
	@JsonBackReference
	private Usuario usuario;
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private Collection<Pedido> itemsPedidos = new ArrayList<>();
	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private Collection<Citas> itemsCitas = new ArrayList<>();

	public Integer getClienteid() {
		return clienteid;
	}

	public void setClienteid(Integer clienteid) {
		this.clienteid = clienteid;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Integer getDni() {
		return Dni;
	}

	public void setDni(Integer dni) {
		Dni = dni;
	}

	public Collection<Citas> getItemsCitas() {
		return itemsCitas;
	}

	public void setItemsCitas(Collection<Citas> itemsCitas) {
		this.itemsCitas = itemsCitas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public LocalDate getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public Collection<Pedido> getItemsPedidos() {
		return itemsPedidos;
	}

	public void setItemsPedidos(Collection<Pedido> itemsPedidos) {
		this.itemsPedidos = itemsPedidos;
	}

}
