package com.cga.sanidad;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.cga.sanidad.dao.PacienteDao;
import com.cga.sanidad.pojo.Paciente;

public class Principal {

	public static void main(String[] args) {

		ApplicationContext apc = new ClassPathXmlApplicationContext("ConfigSpring.xml");

		PacienteDao pacienteDao = (PacienteDao) apc.getBean("PacienteDao");

		Paciente pac = (Paciente) apc.getBean("pac");

//		if (pacienteDao.save(pac)){
//			System.out.println("Paciente Guardado!!!");	
//		} else {
//			System.out.println("Error al insertar Paciente Guardado!!!");
//		}

		try {
//			pacienteDao.save(pac);

		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("Credenciales, Configuraciones!!");
			e.printStackTrace();
		} catch (DataAccessException e) {
			System.out.println("Error en el SQL");
			e.printStackTrace();
		}

		((ClassPathXmlApplicationContext) apc).close();

		List<Paciente> pacientes = pacienteDao.findAll();

		for (Paciente paciente2 : pacientes) {
			System.out.println("Mostrar: " + paciente2);
		}

		System.out.println();
		
		List<Paciente> pacientes4 = pacienteDao.findByNombre("Pepito");

		for (Paciente paciente3 : pacientes4) {
			System.out.println("Mostrar: " + paciente3);
		}
		
		System.out.println();
		
		System.out.println(pacienteDao.findById(1001));
		
	}

}
