package com.sistema.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.modelo.Producto;
import com.sistema.modelo.Proveedor;
import com.sistema.servicios.ProveedorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
    private ProveedorService service;

    // LISTAR
    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET() {
        Collection<Proveedor> collection = service.findAll();
        if (collection.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(collection, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Collection<Proveedor>> registrar_POST(@RequestBody Proveedor proveedor) {
        service.insert(proveedor);
        Collection<Proveedor> listaProveedor = service.findAll(); // Obtén la lista actualizada de productos
        return new ResponseEntity<>(listaProveedor, HttpStatus.CREATED);}
    
    @PutMapping("/editar/{id_proveedor}")
    public ResponseEntity<?> editar(@PathVariable("id_proveedor") Integer id_proveedor,
                                    @RequestBody Proveedor proveedor) {
        try {
            Proveedor proveedorExistente = service.findById(id_proveedor);
            if (proveedorExistente == null) {
                return new ResponseEntity<>("El proveedor no existe", HttpStatus.NOT_FOUND);
            }

            // Actualizar los campos del producto existente
            proveedorExistente.setNombre(proveedor.getNombre());
            proveedorExistente.setTelefono(proveedor.getTelefono());
            proveedorExistente.setDireccion(proveedor.getDireccion());

            // Guardar el producto actualizado en la base de datos
            service.update(proveedorExistente);

            return new ResponseEntity<>(proveedorExistente, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    
    
    @DeleteMapping("/borrar/{id_proveedor}")
    public ResponseEntity<Collection<Proveedor>> borrar_DELETE(@PathVariable Integer id_proveedor) {
        Proveedor proveedordb = service.findById(id_proveedor);
            service.delete(id_proveedor);
            Collection<Proveedor> listaProveedor = service.findAll(); // Obtén la lista actualizada de productos
            return new ResponseEntity<>(listaProveedor, HttpStatus.OK);
        

        
    }
    
    
    @GetMapping("/buscar/{id_proveedor}")
    public ResponseEntity<?> buscar_G(@PathVariable Integer id_proveedor) {
        Proveedor proveedordb = service.findById(id_proveedor);
        if (proveedordb != null) {
            return new ResponseEntity<>(proveedordb, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Proveedor no encontrado", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/productos/{nombre}")
    public ResponseEntity<?> productosPorNombre_GET(@PathVariable String nombre) {
        Proveedor proveedor = service.findByNombre(nombre);
        if (proveedor == null) {
            return new ResponseEntity<>("Proveedor no encontrado", HttpStatus.NOT_FOUND);
        }

        Collection<Producto> productos = proveedor.getItemsProducto();
        if (productos.isEmpty()) {
            return new ResponseEntity<>("El proveedor no tiene productos relacionados", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    @GetMapping("/buscar-nombre/{nombre}")
    public ResponseEntity<?> buscarProveedorPorNombre_GET(@PathVariable String nombre) {
        Proveedor proveedor = service.findByNombre(nombre);
        if (proveedor == null) {
            return new ResponseEntity<>("Proveedor no encontrado", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(proveedor, HttpStatus.OK);
    }


}
