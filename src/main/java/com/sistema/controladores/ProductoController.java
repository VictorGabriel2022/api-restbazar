package com.sistema.controladores;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistema.modelo.Producto;
import com.sistema.servicios.ProductoService;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    // LISTAR
    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET() {
        Collection<Producto> collection = productoService.findAll();
        if (collection.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(collection, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Collection<Producto>> registrar_POST(@RequestBody Producto producto) {
        productoService.insert(producto);
        Collection<Producto> listaProductos = productoService.findAll(); // Obtén la lista actualizada de productos
        return new ResponseEntity<>(listaProductos, HttpStatus.CREATED);}
    
    @PutMapping("/editar/{productoid}")
    public ResponseEntity<?> editar(@PathVariable("productoid") Integer productoId,
                                    @RequestBody Producto producto) {
        try {
            Producto productoExistente = productoService.findById(productoId);
            if (productoExistente == null) {
                return new ResponseEntity<>("El producto no existe", HttpStatus.NOT_FOUND);
            }

            // Actualizar los campos del producto existente
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setCantidad(producto.getCantidad());
            productoExistente.setImagen(producto.getImagen());
          
            // Guardar el producto actualizado en la base de datos
            productoService.update(productoExistente);

            return new ResponseEntity<>(productoExistente, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/editar/estado/{productoid}")
    public ResponseEntity<?> actualizarEstado(@PathVariable("productoid") Integer productoId,
                                              @RequestBody Producto producto) {
        try {
            Producto productoExistente = productoService.findById(productoId);
            if (productoExistente == null) {
                return new ResponseEntity<>("El producto no existe", HttpStatus.NOT_FOUND);
            }

            // Actualizar solo el estado del producto existente
            productoExistente.setEstado(producto.getEstado());

            // Guardar el producto actualizado en la base de datos
            productoService.update(productoExistente);

            return new ResponseEntity<>(productoExistente, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        @PutMapping("/editarcantidad/{productoid}")
        public ResponseEntity<?> editarcantidad(@PathVariable("productoid") Integer productoId,
                                        @RequestBody Producto producto) {
            try {
                Producto productoExistente = productoService.findById(productoId);
                if (productoExistente == null) {
                    return new ResponseEntity<>("El producto no existe", HttpStatus.NOT_FOUND);
                }

                productoExistente.setCantidad(producto.getCantidad());
   
                // Guardar el producto actualizado en la base de datos
                productoService.update(productoExistente);

                return new ResponseEntity<>(productoExistente, HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }


    
    
    @DeleteMapping("/borrar/{productoid}")
    public ResponseEntity<Collection<Producto>> borrar_DELETE(@PathVariable Integer productoid) {
        Producto productodb = productoService.findById(productoid);
            productoService.delete(productoid);
            Collection<Producto> listaProductos = productoService.findAll(); // Obtén la lista actualizada de productos
            return new ResponseEntity<>(listaProductos, HttpStatus.OK);
        

        
    }
    
    
    @GetMapping("/buscar/{productoid}")
    public ResponseEntity<?> buscar_G(@PathVariable Integer productoid) {
        Producto productodb = productoService.findById(productoid);
        if (productodb != null) {
            return new ResponseEntity<>(productodb, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

}



