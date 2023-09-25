package com.cga.sanidad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cga.sanidad.pojo.Paciente;

public class PacienteRowMapper implements RowMapper<Paciente> {
	
	public Paciente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Paciente pac = new Paciente();
		pac.setIdPaciente(rs.getInt("IdPaciente"));
		pac.setNombre(rs.getString("nombre"));
		pac.setApellidos(rs.getString("apellidos"));
		pac.setEdad(rs.getInt("edad"));
		pac.setTelefono(rs.getInt("telefono"));
		pac.setHistorial(rs.getString("historial"));
		return pac;
	}

}
