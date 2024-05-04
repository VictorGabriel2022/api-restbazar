package com.sistema.repositorios;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.modelo.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido, Integer>{
	
	
	@Query(value="SELECT pedidos.*, usuarios.nombre AS nombre_usuario "
			+ "FROM pedidos JOIN usuarios ON pedidos.id_usuario = usuarios.id;",nativeQuery=true)
	public abstract Collection<Object[]> findAll_withPedidos();
	
	List<Pedido> findByClienteClienteid(Integer clienteId);
}
