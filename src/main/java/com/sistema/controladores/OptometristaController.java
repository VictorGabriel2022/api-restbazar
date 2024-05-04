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


import com.sistema.modelo.Optometrista;

import com.sistema.servicios.OptometristaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/optometrista")
public class OptometristaController {

	 @Autowired
	    private OptometristaService optometristaService;
	 
	 // LISTAR
	    @GetMapping("/listar")
	    public ResponseEntity<?> listar_GET() {
	        Collection<Optometrista> collection =optometristaService.findAll();
	        if (collection.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(collection, HttpStatus.OK);
	    }

	    @PostMapping("/registrar")
	    public ResponseEntity<Collection<Optometrista>> registrar_POST(@RequestBody Optometrista optometrista) {
	    	optometristaService.insert(optometrista);
	        Collection<Optometrista> listaOptometrista = optometristaService.findAll(); // Obtén la lista actualizada de productos
	        return new ResponseEntity<>(listaOptometrista, HttpStatus.CREATED);}
	    
	    @PutMapping("/editar/{optometristaid}")
	    public ResponseEntity<?> editar(@PathVariable("optometristaid") Integer optometristaid,
	                                    @RequestBody Optometrista optometrista) {
	        try {
	        	Optometrista OptometristaExistente = optometristaService.findById(optometristaid);
	            if (OptometristaExistente  == null) {
	                return new ResponseEntity<>("El Optometrista no existe", HttpStatus.NOT_FOUND);
	            }

	            // Actualizar los campos del producto existente
	            OptometristaExistente.setNombre(optometrista.getNombre());
	            OptometristaExistente.setTelefono(optometrista.getTelefono());
	            OptometristaExistente.setDni(optometrista.getDni());
	            OptometristaExistente.setDireccion(optometrista.getDireccion());
	            OptometristaExistente.setHorario(optometrista.getHorario());
	            
	            // Guardar el producto actualizado en la base de datos
	            optometristaService.update(OptometristaExistente);

	            return new ResponseEntity<>(OptometristaExistente, HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    @DeleteMapping("/borrar/{optometristaid}")
	    public ResponseEntity<Collection<Optometrista>> borrar_DELETE(@PathVariable Integer optometristaid) {
	    	Optometrista Optometristadb = optometristaService.findById(optometristaid);
	    	    optometristaService.delete(optometristaid);
	            Collection<Optometrista> listaOptometrista = optometristaService.findAll(); 
	            return new ResponseEntity<>(listaOptometrista, HttpStatus.OK);
	        

	        
	    }
}
