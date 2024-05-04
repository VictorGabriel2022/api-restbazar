package com.sistema.servicios;

import java.util.Collection;
import java.util.List;

import com.sistema.modelo.DetalleHojaCompra;

public interface DhojaService {
	public abstract Collection<DetalleHojaCompra> findAll();
	public abstract void insert(DetalleHojaCompra dhoja);
	public abstract void insertAll(List<DetalleHojaCompra> dhojaList);
}
