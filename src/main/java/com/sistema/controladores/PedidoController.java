package com.sistema.controladores;

import java.util.Collection;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sistema.modelo.Pedido;
import com.sistema.servicios.PedidoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pedido")
public class PedidoController {
	 @Autowired
	    private PedidoService pedidoService;
	 // LISTAR
	    @GetMapping("/listar")
	    public ResponseEntity<?> listar_GET() {
	        Collection<Pedido> collection = pedidoService.findAll();
	        if (collection.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(collection, HttpStatus.OK);
	    }

	    @PostMapping("/registrar")
	    public ResponseEntity<Pedido> registrar_POST(@RequestBody Pedido pedido) {
	       // Inserta el pedido en la base de datos
            String codigo = generarCodigoAleatorio();
            pedido.setCodigo(codigo);
            pedidoService.insert(pedido); 
	        // Asigna el ID generado al pedido
	        Pedido pedidoInsertado = pedidoService.findById(pedido.getId());
	        return new ResponseEntity<>(pedidoInsertado, HttpStatus.CREATED);
	    }
	    
		private String generarCodigoAleatorio() { 
	    	String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; int longitudCodigo = 8; 
	    	StringBuilder codigoAleatorio = new StringBuilder(); Random random = new Random(); for (int i = 0; i < longitudCodigo; i++)
	    	{ int index = random.nextInt(caracteresPermitidos.length()); char caracter = caracteresPermitidos.charAt(index); codigoAleatorio.append(caracter); } 
	    	return codigoAleatorio.toString(); }
		@GetMapping("/listar1")
		public ResponseEntity<?> listar1_GET() {
			return new ResponseEntity<>(pedidoService.findAll_withPedidos(),HttpStatus.OK);
		}
		
		@GetMapping("/cliente/{clienteId}")
	    public ResponseEntity<Collection<Pedido>> getCitasByClienteId(@PathVariable Integer clienteId) {
	        Collection<Pedido> pedido = pedidoService.getPedidoByClienteId(clienteId);
	        return ResponseEntity.ok(pedido);
	    }
		
		
		@PutMapping("/editarPedido/{Id}") 
	    public ResponseEntity<?> editar(@PathVariable Integer Id, @RequestBody Pedido newPedido) {
	    try {
	   	      Pedido pedidoDb=pedidoService.findById(Id); 
	   	 if(pedidoDb  == null) {
	   	   return new ResponseEntity<>("El Pedido no existe", HttpStatus.NOT_FOUND);
	   		 
	   	 }
	   		pedidoDb.setEstado(newPedido.getEstado());
	   		
	   		pedidoService.update(pedidoDb); 
	   		return new ResponseEntity<>(pedidoDb, HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        } 
	  } 
		
	}

	  

