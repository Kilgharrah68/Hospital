package com.cga.sanidad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.cga.sanidad.pojo.Paciente;

@Component("PacienteDao") // Identificador de la Interface

public class PacienteDaoImpl implements PacienteDao {

	// Plantilla para evitar inteccion de sql
	private NamedParameterJdbcTemplate jdbcTemplate;

	// Hace referncia el fichero config.xml, dataSource
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Paciente paciente) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("idPaciente", paciente.getIdPaciente());
		map.addValue("nombre", paciente.getNombre());
		map.addValue("apellidos", paciente.getApellidos());
		map.addValue("edad", paciente.getEdad());
		map.addValue("telefono", paciente.getTelefono());
		map.addValue("direccion", null);
		// map.addValue("direccion", paciente.getDireccion());
		map.addValue("historial", paciente.getHistorial());
		return jdbcTemplate.update(
				"insert into pacientes  VALUES(:idPaciente,:nombre,:apellidos,:edad,:telefono,null,:historial)",
				map) == 1;
	}

	@Override
	public List<Paciente> findAll() {

		return jdbcTemplate.query("select * from pacientes", new PacienteRowMapper());
				
//				RowMapper<Paciente>() {
//
//			@Override
//			public Paciente mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Paciente pac = new Paciente();
//				pac.setIdPaciente(rs.getInt("IdPaciente"));
//				pac.setNombre(rs.getString("nombre"));
//				pac.setApellidos(rs.getString("apellidos"));
//				pac.setEdad(rs.getInt("edad"));
//				pac.setTelefono(rs.getInt("telefono"));
//				pac.setHistorial(rs.getString("historial"));
//
//				return pac;
//			}
		}



	@Override
	public List<Paciente> findByNombre(String nombre) {
		return jdbcTemplate.query("select * from pacientes where nombre like :nombre", new MapSqlParameterSource("nombre", "%" + nombre + "%") , new PacienteRowMapper());
		
	}

	@Override
	public Paciente findById(int id) {
		return jdbcTemplate.queryForObject("select * from pacientes where idPaciente = :IdPaciente", new MapSqlParameterSource("idPaciente", id ) , new PacienteRowMapper());
	}
}
