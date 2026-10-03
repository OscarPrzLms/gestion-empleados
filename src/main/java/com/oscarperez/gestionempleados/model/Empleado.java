package com.oscarperez.gestionempleados.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {
	
	 @Id
	 @GeneratedValue(
			 strategy = GenerationType.SEQUENCE,
			 generator = "empleado_seq_generator"
	)
	@SequenceGenerator(
	    name = "empleado_seq_generator",
	    sequenceName = "SEQ_EMPLEADO",
	    allocationSize = 1
	)
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "NOMBRE", nullable = false, length = 100)
	 private String nombre;

	 @Column(name = "APELLIDO_PATERNO", nullable = false, length = 100)
	 private String apellidoPaterno;

	 @Column(name = "APELLIDO_MATERNO", length = 100)
	 private String apellidoMaterno;

	 @Column(name = "CORREO", nullable = false, length = 150)
	 private String correo;

	 @Column(name = "TELEFONO", length = 20)
	 private String telefono;

	 @Column(name = "PUESTO", nullable = false, length = 100)
	 private String puesto;

	 @Column(name = "SALARIO", nullable = false, precision = 12, scale = 2)
	 private BigDecimal salario;

	 @Column(name = "FECHA_INGRESO", nullable = false)
	 private LocalDate fechaIngreso;

	 @Column(name = "ESTATUS", nullable = false, length = 20)
	 private String estatus;
	 
	 public Empleado() {
	 }

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public String getNombre() {
		 return nombre;
	 }

	 public void setNombre(String nombre) {
		 this.nombre = nombre;
	 }

	 public String getApellidoPaterno() {
		 return apellidoPaterno;
	 }

	 public void setApellidoPaterno(String apellidoPaterno) {
		 this.apellidoPaterno = apellidoPaterno;
	 }

	 public String getApellidoMaterno() {
		 return apellidoMaterno;
	 }

	 public void setApellidoMaterno(String apellidoMaterno) {
		 this.apellidoMaterno = apellidoMaterno;
	 }

	 public String getCorreo() {
		 return correo;
	 }

	 public void setCorreo(String correo) {
		 this.correo = correo;
	 }

	 public String getTelefono() {
		 return telefono;
	 }

	 public void setTelefono(String telefono) {
		 this.telefono = telefono;
	 }

	 public String getPuesto() {
		 return puesto;
	 }

	 public void setPuesto(String puesto) {
		 this.puesto = puesto;
	 }

	 public BigDecimal getSalario() {
		 return salario;
	 }

	 public void setSalario(BigDecimal salario) {
		 this.salario = salario;
	 }

	 public LocalDate getFechaIngreso() {
		 return fechaIngreso;
	 }

	 public void setFechaIngreso(LocalDate fechaIngreso) {
		 this.fechaIngreso = fechaIngreso;
	 }

	 public String getEstatus() {
		 return estatus;
	 }

	 public void setEstatus(String estatus) {
		 this.estatus = estatus;
	 } 
	 
}
