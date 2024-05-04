package com.sistema.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "cita")
public class Citas implements Serializable {
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citaid;
	
	@Column
	private Integer telefono;
	
	@Column
	private String correo;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy",iso=ISO.DATE)
	private LocalDate fechasolicitud;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy",iso=ISO.DATE) 
	private LocalDate fechaatencion;
	@DateTimeFormat(pattern = "HH:mm:ss",iso=ISO.TIME)
	private LocalTime horaatencion;
	private String Asunto;
	@Column
	private Boolean estado=false;
	
	public Citas() {	}
	
	public Citas(Integer citaid, Integer telefono, String correo, LocalDate fechasolicitud, LocalDate fechaatencion,
			LocalTime horaatencion, String asunto, Boolean estado) {
		this.citaid = citaid;
		this.telefono = telefono;
		this.correo = correo;
		this.fechasolicitud = fechasolicitud;
		this.fechaatencion = fechaatencion;
		this.horaatencion = horaatencion;
		Asunto = asunto;
		this.estado = estado;
	}
	
	@ManyToOne
		@JoinColumn(name="optometrista_id",nullable=false)	
	    private Optometrista optometrista;
	@ManyToOne
	@JoinColumn(name="cliente_id",nullable=false)	
    private Cliente cliente;
	@PostPersist
	public void portPersist() {
		fechasolicitud=LocalDate.now();
	}


	public String getAsunto() {
		return Asunto;
	}


	public void setAsunto(String asunto) {
		Asunto = asunto;
	}


	public Integer getCitaid() {
		return citaid;
	}

	public void setCitaid(Integer citaid) {
		this.citaid = citaid;
	}

	public LocalDate getFechasolicitud() {
		return fechasolicitud;
	}

	public void setFechasolicitud(LocalDate fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
	}

	public LocalDate getFechaatencion() {
		return fechaatencion;
	}

	public void setFechaatencion(LocalDate fechaatencion) {
		this.fechaatencion = fechaatencion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Optometrista getOptometrista() {
		return optometrista;
	}

	public void setOptometrista(Optometrista optometrista) {
		this.optometrista = optometrista;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public LocalTime getHoraatencion() {
		return horaatencion;
	}

	public void setHoraatencion(LocalTime horaatencion) {
		this.horaatencion = horaatencion;
	}

}
