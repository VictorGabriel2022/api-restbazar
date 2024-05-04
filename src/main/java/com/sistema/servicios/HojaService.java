package com.sistema.servicios;

import java.util.Collection;
import java.util.Optional;

import com.sistema.modelo.HojaCompra;
import com.sistema.modelo.Producto;


public interface HojaService {
	public abstract Collection<HojaCompra> findAll();

	public abstract void insert(HojaCompra hoja);
    public abstract HojaCompra findById(Integer idHojacompra);
	public abstract void update(HojaCompra hoja);
	public abstract void delete(Integer idHojacompra);

	
}
