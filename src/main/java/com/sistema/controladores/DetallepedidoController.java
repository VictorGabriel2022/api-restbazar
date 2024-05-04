package com.sistema.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.modelo.Detallepedido;

import com.sistema.servicios.DetallepedidoService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/detallepedido")
public class DetallepedidoController {
	@Autowired
    private DetallepedidoService dpService;
	 // LISTAR
    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET() {
        Collection<Detallepedido> collection = dpService.findAll();
        if (collection.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(collection, HttpStatus.OK);
  }

    @PostMapping("/registrar")
    public ResponseEntity<Collection<Detallepedido>> registrar_POST(@RequestBody Detallepedido dppedido) {
    	dpService.insert(dppedido);
        Collection<Detallepedido> listaDetallePedido = dpService.findAll(); // Obtén la lista actualizada de productos
        return new ResponseEntity<>(listaDetallePedido, HttpStatus.CREATED);}
}


