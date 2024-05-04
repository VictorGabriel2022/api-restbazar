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

import com.sistema.modelo.Categoria;
import com.sistema.repositorios.CategoriaRepository;
import com.sistema.servicios.CategoriaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("categoria")
public class CategoriaController {

	@Autowired
    private CategoriaService service;
 	 // LISTAR
    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET() {
        Collection<Categoria> collection = service.findAll();
        if (collection.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(collection, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Collection<Categoria>> registrar_POST(@RequestBody Categoria categoria) {
        service.insert(categoria);
        Collection<Categoria> listaCategoria = service.findAll(); // Obtén la lista actualizada de productos
        return new ResponseEntity<>(listaCategoria, HttpStatus.CREATED);}
    
    @PutMapping("/editar/{id_categoria}")
    public ResponseEntity<?> editar(@PathVariable("id_categoria") Integer id_categoria,
                                    @RequestBody Categoria categoria) {
        try {
            Categoria categoriaExistente = service.findById(id_categoria);
            if (categoriaExistente  == null) {
                return new ResponseEntity<>("La categoria no existe", HttpStatus.NOT_FOUND);
            }
            // Actualizar los campos del producto existente	           
            categoriaExistente.setNombre(categoria.getNombre());
        
            // Guardar el producto actualizado en la base de datos
            service.update(categoriaExistente);
            return new ResponseEntity<>(categoriaExistente, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/borrar/{id_categoria}")
    public ResponseEntity<Collection<Categoria>> borrar_DELETE(@PathVariable Integer id_categoria) {
        Categoria categoriadb = service.findById(id_categoria);
            service.delete(id_categoria);
            Collection<Categoria> listaCategoria = service.findAll(); 
            return new ResponseEntity<>(listaCategoria, HttpStatus.OK);	        
    }
}
