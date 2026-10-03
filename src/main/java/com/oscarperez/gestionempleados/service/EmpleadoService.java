package com.oscarperez.gestionempleados.service;

import java.util.List;
import java.util.Optional;

import com.oscarperez.gestionempleados.model.Empleado;

public interface EmpleadoService {
	
	Empleado guardar(Empleado empleado);
	
	List<Empleado> listarTodos();
	
	Optional<Empleado> buscarPorId(Long id);
	
	Empleado actualizar(Long id, Empleado empleado);
	
	boolean eliminar(Long id);

}
 