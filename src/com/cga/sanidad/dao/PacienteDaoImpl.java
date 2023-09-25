package com.cga.sanidad.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.cga.sanidad.pojo.Paciente;

@Component("PacienteDao") //Identificador de la Interface

public class PacienteDaoImpl implements PacienteDao {

	
	// Plantilla para evitar inteccion de sql
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	// Hace referncia el fichero config.xml, dataSource
	@Autowired 
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public boolean save (Paciente paciente) {
		MapSqlParameterSource map = new  MapSqlParameterSource();
		map.addValue("idPaciente", paciente.getIdPaciente());
		map.addValue("nombre", paciente.getNombre());
		map.addValue("apellidos", paciente.getApellidos());
		map.addValue("edad", paciente.getEdad());
		map.addValue("telefono", paciente.getTelefono());
		map.addValue("direccion", null);
		//map.addValue("direccion", paciente.getDireccion());
		map.addValue("historial", paciente.getHistorial());
		return jdbcTemplate.update("insert into pacientes  VALUES(:idPaciente,:nombre,:apellidos,:edad,:telefono,null,:historial)", map)==1;
	}
}
