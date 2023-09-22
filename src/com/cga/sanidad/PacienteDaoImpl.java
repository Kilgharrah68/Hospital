package com.cga.sanidad;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("PacienteDao")

public class PacienteDaoImpl implements PacienteDao {
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
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
