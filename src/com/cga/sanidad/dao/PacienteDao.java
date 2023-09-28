package com.cga.sanidad.dao;

import java.util.List;

import com.cga.sanidad.pojo.Paciente;

public interface PacienteDao {
 	// M�todo para guardar un paciente en la base de datos
	public boolean save (Paciente paciente);
	
	// M�todo para buscar y obtener todos los pacientes
	public List<Paciente> findAll();
	
	// M�todo para buscar y obtener un paciente por su ID
	public Paciente findById(int id);
	
	// M�todo para buscar y obtener pacientes por su nombre
	public List<Paciente> findByNombre(String nombre);
	
	// M�todo para actualizar la información de un paciente
	public boolean update(Paciente paciente);
	
	// M�todo para eliminar un paciente por su ID
	public boolean delete(int idPaciente);
	
	// M�todo para guardar una lista de pacientes en la base de datos
	public int[] saveAll(List<Paciente> pacientes);
	
}
