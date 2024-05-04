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

import com.sistema.modelo.Cliente;
import com.sistema.servicios.ClienteService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	 @Autowired
	    private ClienteService clienteService;
	 
	 // LISTAR
	    @GetMapping("/listar")
	    public ResponseEntity<?> listar_GET() {
	        Collection<Cliente> collection = clienteService.findAll();
	        if (collection.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(collection, HttpStatus.OK);
	    }

	    @PostMapping("/registrar")
	    public ResponseEntity<Collection<Cliente>> registrar_POST(@RequestBody Cliente cliente) {
	        clienteService.insert(cliente);
	        Collection<Cliente> listaCliente = clienteService.findAll(); // Obtén la lista actualizada de productos
	        return new ResponseEntity<>(listaCliente, HttpStatus.CREATED);}
	    
	    @PutMapping("/editar/{clienteid}")
	    public ResponseEntity<?> editar(@PathVariable("clienteid") Integer clienteid,
	                                    @RequestBody Cliente cliente) {
	        try {
	            Cliente clienteExistente = clienteService.findById(clienteid);
	            if (clienteExistente  == null) {
	                return new ResponseEntity<>("El producto no existe", HttpStatus.NOT_FOUND);
	            }

	            // Actualizar los campos del producto existente
	            clienteExistente.setNombre(cliente.getNombre());
	            clienteExistente.setApellido(cliente.getApellido());
	            clienteExistente.setDni(cliente.getDni());
	            clienteExistente.setFechaNacimiento(cliente.getFechaNacimiento());
	            
	    

	            // Guardar el producto actualizado en la base de datos
	            clienteService.update(clienteExistente);

	            return new ResponseEntity<>(clienteExistente, HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    @DeleteMapping("/borrar/{clienteid}")
	    public ResponseEntity<Collection<Cliente>> borrar_DELETE(@PathVariable Integer clienteid) {
	        Cliente clientedb = clienteService.findById(clienteid);
	            clienteService.delete(clienteid);
	            Collection<Cliente> listaCliente = clienteService.findAll(); // Obtén la lista actualizada de productos
	            return new ResponseEntity<>(listaCliente, HttpStatus.OK);
	        

	        
	    }
	    @GetMapping("/buscar/{clienteid}")
			public ResponseEntity<?> buscar_GET(@PathVariable Integer clienteid)
			{
				Cliente citadb=clienteService.findById(clienteid);	
				if(citadb!=null) {
					return new ResponseEntity<>(citadb,HttpStatus.FOUND);
				}
				return new ResponseEntity<>("¡Producto ID "+clienteid+" no encontrado!",HttpStatus.NOT_FOUND);
			}

}
