package com.cga.sanidad.dao;

import java.util.List;

import com.cga.sanidad.pojo.Paciente;

public interface PacienteDao {
 	// MÈtodo para guardar un paciente en la base de datos
	public boolean save (Paciente paciente);
	
	// MÈtodo para buscar y obtener todos los pacientes
	public List<Paciente> findAll();
	
	// MÈtodo para buscar y obtener un paciente por su ID
	public Paciente findById(int id);
	
	// MÈtodo para buscar y obtener pacientes por su nombre
	public List<Paciente> findByNombre(String nombre);
	
	// MÈtodo para actualizar la informaci√≥n de un paciente
	public boolean update(Paciente paciente);
	
	// MÈtodo para eliminar un paciente por su ID
	public boolean delete(int idPaciente);
	
	// MÈtodo para guardar una lista de pacientes en la base de datos
	public int[] saveAll(List<Paciente> pacientes);
	
}
