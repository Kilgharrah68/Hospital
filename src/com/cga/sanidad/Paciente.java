package com.cga.sanidad;

import org.springframework.beans.factory.annotation.Autowired;

public class Paciente {

	
	//Atributos
	private int idPaciente;
	private String nombre;
	private String apellidos;
	private int edad;
	private int telefono;
	//private String direccion;
	private Direccion direccion;
	private String historial;
	
	//Constructor vacio
	public Paciente() {
	}
	
	//Constructor con parámetros
	public Paciente(int idPaciente, String nombre, String apellidos, int edad, int telefono, Direccion direccion,
			String historial) {
		this.idPaciente = idPaciente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.telefono = telefono;
		this.direccion = direccion;
		this.historial = historial;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Autowired
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public void setHistorial(String historial) {
		this.historial = historial;
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad="
				+ edad + ", telefono=" + telefono + ", direccion=" + direccion + ", historial=" + historial + "]";
	}
	
	public void imprimirHistorial () {
	System.out.println("Paciente con Historial");
}

	public int getIdPaciente() {
		return idPaciente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public int getTelefono() {
		return telefono;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public String getHistorial() {
		return historial;
	}
	
	
}
