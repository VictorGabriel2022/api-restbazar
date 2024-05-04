package com.sistema.controladores;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.modelo.Categoria;
import com.sistema.modelo.DetalleHojaCompra;
import com.sistema.servicios.DhojaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("dhoja")
public class DhojaController {
	@Autowired
    private DhojaService service;
	 // LISTAR
    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET() {
        Collection<DetalleHojaCompra> collection = service.findAll();
        if (collection.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(collection, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Collection<DetalleHojaCompra>> registrar_POST(@RequestBody List<DetalleHojaCompra> dhojaList) {
        service.insertAll(dhojaList); // Cambia el método insert según lo que tengas en tu servicio
        Collection<DetalleHojaCompra> listahoja = service.findAll(); // Obtén la lista actualizada de productos
        return new ResponseEntity<>(listahoja, HttpStatus.CREATED);
    }

}
