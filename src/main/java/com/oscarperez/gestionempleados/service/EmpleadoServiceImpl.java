package com.oscarperez.gestionempleados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oscarperez.gestionempleados.model.Empleado;
import com.oscarperez.gestionempleados.repository.EmpleadoRepository;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	private final EmpleadoRepository empleadoRepository;
	
	public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}

	@Override
	public Empleado guardar(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public List<Empleado> listarTodos() {
		
		return empleadoRepository.findAll();
	}

	@Override
	public Optional<Empleado> buscarPorId(Long id) {
	
		return  empleadoRepository.findById(id);
	}

	@Override
	public Empleado actualizar(Long id, Empleado empleado) {  

		 Optional<Empleado> empleadoExistente = empleadoRepository.findById(id);
		 
		 if (empleadoExistente.isPresent()) {
			 
			  Empleado empleadoActual = empleadoExistente.get();
			  
			  empleadoActual.setNombre(empleado.getNombre());
		      empleadoActual.setApellidoPaterno(empleado.getApellidoPaterno());
		      empleadoActual.setApellidoMaterno(empleado.getApellidoMaterno());
		      empleadoActual.setCorreo(empleado.getCorreo());
		      empleadoActual.setTelefono(empleado.getTelefono());
		      empleadoActual.setPuesto(empleado.getPuesto());
		      empleadoActual.setSalario(empleado.getSalario());
		      empleadoActual.setFechaIngreso(empleado.getFechaIngreso());
		      empleadoActual.setEstatus(empleado.getEstatus());
		      
		      return empleadoRepository.save(empleadoActual);
		 }
		
		return null;
	}

	
	@Override
	public boolean eliminar(Long id) {
		if (empleadoRepository.existsById(id)) {
	        empleadoRepository.deleteById(id);
	        return true;
	    }	
		
		return false;
	}
	
}
