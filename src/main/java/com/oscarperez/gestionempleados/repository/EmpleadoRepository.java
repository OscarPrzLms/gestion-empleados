package com.oscarperez.gestionempleados.repository;

import com.oscarperez.gestionempleados.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
