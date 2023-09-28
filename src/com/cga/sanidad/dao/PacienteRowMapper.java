package com.cga.sanidad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cga.sanidad.pojo.Paciente;

public class PacienteRowMapper implements RowMapper<Paciente> {

	// Método de mapeo que convierte una fila de la base de datos en un objeto Paciente
	public Paciente mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// Crear una nueva instancia de Paciente
		Paciente pac = new Paciente();
		
		// Asignar valores de las columnas de la fila ResultSet al objeto Paciente
		pac.setIdPaciente(rs.getInt("IdPaciente"));
		pac.setNombre(rs.getString("nombre"));
		pac.setApellidos(rs.getString("apellidos"));
		pac.setEdad(rs.getInt("edad"));
		pac.setTelefono(rs.getInt("telefono"));
		pac.setHistorial(rs.getString("historial"));

		// Devolver el objeto Paciente mapeado
		return pac;
	}

}
