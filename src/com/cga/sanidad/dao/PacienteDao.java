package com.cga.sanidad.dao;

import java.util.List;

import com.cga.sanidad.pojo.Paciente;

public interface PacienteDao {
 	// Método para guardar un paciente en la base de datos
	public boolean save (Paciente paciente);
	
	// Método para buscar y obtener todos los pacientes
	public List<Paciente> findAll();
	
	// Método para buscar y obtener un paciente por su ID
	public Paciente findById(int id);
	
	// Método para buscar y obtener pacientes por su nombre
	public List<Paciente> findByNombre(String nombre);
	
	// Método para actualizar la información de un paciente
	public boolean update(Paciente paciente);
	
	// Método para eliminar un paciente por su ID
	public boolean delete(int idPaciente);
	
	// Método para guardar una lista de pacientes en la base de datos
	public int[] saveAll(List<Paciente> pacientes);
	
}
