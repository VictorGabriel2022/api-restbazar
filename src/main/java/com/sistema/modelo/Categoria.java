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

import com.sistema.modelo.Producto;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcategoria;
	@Column(unique = true,nullable = false)
	private String nombre;
	
	public Categoria() {
	}

	public Categoria(Integer id_categoria, String nombre) {
		this.idcategoria = id_categoria;
		this.nombre = nombre;
	}
	
	@OneToMany(mappedBy = "categoria")
	private Collection<Producto> itemsCategoria=new ArrayList<>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
	}
	
}
