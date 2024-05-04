package com.sistema.controladores;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

import com.sistema.modelo.Categoria;
import com.sistema.modelo.DetalleHojaCompra;
import com.sistema.modelo.HojaCompra;
import com.sistema.modelo.Producto;
import com.sistema.servicios.HojaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hojacompra")
public class HojaController {
	
	
@Autowired 
  private HojaService hojaservice;


@GetMapping("/listar")
public ResponseEntity<?> listar_GET() {
    Collection<HojaCompra> collection = hojaservice.findAll();
    if (collection.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(collection, HttpStatus.OK);
}
@PostMapping("/registrar")
public ResponseEntity<Collection<HojaCompra>> registrar_POST(@RequestBody HojaCompra hoja) {
    hojaservice.insert(hoja);
    Collection<HojaCompra> listahoja = hojaservice.findAll(); // Obtén la lista actualizada de productos
    return new ResponseEntity<>(listahoja, HttpStatus.CREATED);}

@PutMapping("/editar/estado/{hojaid}")
public ResponseEntity<?> actualizarEstado(@PathVariable("hojaid") Integer hojaId,
                                          @RequestBody HojaCompra hoja) {
    try {
        HojaCompra hojaExistente = hojaservice.findById(hojaId);
        if (hojaExistente == null) {
            return new ResponseEntity<>("La hoja no existe", HttpStatus.NOT_FOUND);
        }

        // Actualizar solo el estado del producto existente
        hojaExistente.setEstado(hoja.getEstado());
        hojaExistente.setNrofactura(hoja.getNrofactura());
        hojaExistente.setFecha(hoja.getFecha());

        // Guardar el producto actualizado en la base de datos
        hojaservice.update(hojaExistente);

        return new ResponseEntity<>(hojaExistente, HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


@GetMapping("/detalles/{idHojacompra}")
public ResponseEntity<?> detallesPorHojacompra_GET(@PathVariable Integer idHojacompra) {
    HojaCompra hojaCompra = hojaservice.findById(idHojacompra);
    
    if (hojaCompra == null) {
        return new ResponseEntity<>("Hoja de compra no encontrada", HttpStatus.NOT_FOUND);
    }
    
    Collection<DetalleHojaCompra> detalles = hojaCompra.getItemsdetallehojacompra();
    
    if (detalles.isEmpty()) {
        return new ResponseEntity<>("No hay detalles para esta hoja de compra", HttpStatus.NO_CONTENT);
    }
    
    return new ResponseEntity<>(detalles, HttpStatus.OK);
}

}
