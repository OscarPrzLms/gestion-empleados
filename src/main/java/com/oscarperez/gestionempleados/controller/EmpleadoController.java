package com.oscarperez.gestionempleados.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oscarperez.gestionempleados.service.EmpleadoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.oscarperez.gestionempleados.model.Empleado;

import java.util.List;



@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
	
	private final EmpleadoService empleadoService;
	
	public EmpleadoController(EmpleadoService empleadoService) {
	    this.empleadoService = empleadoService;
	}
	
	@PostMapping
	public ResponseEntity<Empleado> registrar(@RequestBody Empleado empleado) {

	    Empleado empleadoGuardado = empleadoService.guardar(empleado);

	    return ResponseEntity
	            .status(HttpStatus.CREATED)
	            .body(empleadoGuardado);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Empleado>> listarTodos() {

	    List<Empleado> empleados = empleadoService.listarTodos();   

	    return ResponseEntity.ok(empleados);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> buscarPorId(@PathVariable Long id) {

	    return empleadoService.buscarPorId(id)
	            .map(ResponseEntity::ok)
	            .orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Empleado> actualizar(
	        @PathVariable Long id,
	        @RequestBody Empleado empleado) {

	    Empleado empleadoActualizado = empleadoService.actualizar(id, empleado);

	    if (empleadoActualizado != null) {
	        return ResponseEntity.ok(empleadoActualizado);
	    }

	    return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) { 

	    boolean eliminado = empleadoService.eliminar(id);

	    if (eliminado) {
	        return ResponseEntity.noContent().build();
	    }

	    return ResponseEntity.notFound().build();
	}

}
