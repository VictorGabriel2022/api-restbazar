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

import com.sistema.modelo.Citas;
import com.sistema.servicios.CitasService;

import antlr.collections.List;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cita")
public class CitasController {

	 @Autowired
	    private CitasService citasService;
	 	 // LISTAR
	    @GetMapping("/listar")
	    public ResponseEntity<?> listar_GET() {
	        Collection<Citas> collection = citasService.findAll();
	        if (collection.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(collection, HttpStatus.OK);
	    }

	    @PostMapping("/registrar")
	    public ResponseEntity<Collection<Citas>> registrar_POST(@RequestBody Citas citas) {
	        citasService.insert(citas);
	        Collection<Citas> listaCita = citasService.findAll(); // Obtén la lista actualizada de productos
	        return new ResponseEntity<>(listaCita, HttpStatus.CREATED);}
	    
	    @PutMapping("/editar/{citaid}")
	    public ResponseEntity<?> editar(@PathVariable("citaid") Integer citaid,
	                                    @RequestBody Citas citas) {
	        try {
	            Citas citaExistente = citasService.findById(citaid);
	            if (citaExistente  == null) {
	                return new ResponseEntity<>("La cita no existe", HttpStatus.NOT_FOUND);
	            }
	            // Actualizar los campos del producto existente	  
	            citaExistente.setTelefono(citas.getTelefono());
	            citaExistente.setCorreo(citas.getCorreo());
	            citaExistente.setFechasolicitud(citas.getFechasolicitud());
	            citaExistente.setHoraatencion(citas.getHoraatencion());
	            citaExistente.setFechaatencion(citas.getFechaatencion());
	            citaExistente.setEstado(citas.getEstado()); 
	   
	            citaExistente.setCliente(citas.getCliente()); 
	            citaExistente.setOptometrista(citas.getOptometrista());
	        
	            // Guardar el producto actualizado en la base de datos
	            citasService.update(citaExistente);
	            return new ResponseEntity<>(citaExistente, HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    @DeleteMapping("/borrar/{citaid}")
	    public ResponseEntity<Collection<Citas>> borrar_DELETE(@PathVariable Integer citaid) {
	        Citas citadb = citasService.findById(citaid);
	            citasService.delete(citaid);
	            Collection<Citas> listaCliente = citasService.findAll(); 
	            return new ResponseEntity<>(listaCliente, HttpStatus.OK);	        
	    }
	    @GetMapping("/buscar/{citaid}")
		public ResponseEntity<?> buscar_GET(@PathVariable Integer productoId)
		{
			Citas citadb=citasService.findById(productoId);	
			if(citadb!=null) {
				return new ResponseEntity<>(citadb,HttpStatus.FOUND);
			}
			return new ResponseEntity<>("¡Producto ID "+productoId+" no encontrado!",HttpStatus.NOT_FOUND);
		}
	    @GetMapping("/cliente/{clienteId}")
	    public ResponseEntity<Collection<Citas>> getCitasByClienteId(@PathVariable Integer clienteId) {
	        Collection<Citas> citas = citasService.getCitasByClienteId(clienteId);
	        return ResponseEntity.ok(citas);
	    }

}
