package com.cga.sanidad;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.cga.sanidad.dao.PacienteDao;
import com.cga.sanidad.pojo.Paciente;

public class Principal {

	public static void main(String[] args) {

		ApplicationContext apc = new ClassPathXmlApplicationContext("ConfigSpring.xml");

		PacienteDao pacienteDao = (PacienteDao) apc.getBean("PacienteDao");

		((ClassPathXmlApplicationContext) apc).close();

		try {

			boolean salir = false;

			do {

				int opc = Integer.parseInt(JOptionPane.showInputDialog(
						"0 Listar todos los pacientes\n" + "1 Listar por Nombre\n" + "2 Mostrar Paciente\n"
								+ "3 Añadir\n" + "4 Modificar\n" + "5 Eliminar\n" + "6 Salir: \n\n"));
				switch (opc) {
				case 6:
					salir = true;
					break;
				case 0: // Listar todos los pacientes
					List<Paciente> pacientes = pacienteDao.findAll();

					for (Paciente pacienteL : pacientes) {
						System.out.println("Mostrar: " + pacienteL);
					}
					break;
				case 1: // Listar por Nombre
					List<Paciente> pacientesN = pacienteDao
							.findByNombre(JOptionPane.showInputDialog("Nombre de paciente: "));

					for (Paciente pacienteN : pacientesN) {
						System.out.println("Mostrar: " + pacienteN);
					}
					break;
				case 2: // Mostrar Paciente

					System.out.println(
							pacienteDao.findById(Integer.parseInt(JOptionPane.showInputDialog("Id de paciente: "))));

					break;

				case 3: // Añadir Paciente

					Paciente pacN = new Paciente();

					pacN.setIdPaciente(Integer.parseInt(JOptionPane.showInputDialog("Id Paciente: ")));
					pacN.setNombre(JOptionPane.showInputDialog("Nombre: "));
					pacN.setApellidos(JOptionPane.showInputDialog("Apellidos: "));
					pacN.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Edad: ")));
					pacN.setTelefono(Integer.parseInt(JOptionPane.showInputDialog("Telefono: ")));
					pacN.setHistorial(JOptionPane.showInputDialog("Historial: "));

					if (pacienteDao.save(pacN)) {
						System.out.println("Pacinete Añadido " + pacN);
					} else {
						System.out.println("Error al añadir el paciente!!!");
					}

					break;

				case 4: // Modificar Paciente
					try {
						Paciente pacM = pacienteDao.findById(
								Integer.parseInt(JOptionPane.showInputDialog("Id de paciente a modificar: ")));

						System.out.println("Paciente con ID  id 1:" + pacM);

						String nombre = JOptionPane.showInputDialog(null, "Nombre: ", pacM.getNombre());
						String apellidos = JOptionPane.showInputDialog(null, "Apellidos: ", pacM.getApellidos());
						int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad: ", pacM.getEdad()));
						int telefono = Integer
								.parseInt(JOptionPane.showInputDialog(null, "Telefono: ", pacM.getTelefono()));
						String historial = JOptionPane.showInputDialog(null, "Historial: ", pacM.getHistorial());

						pacM.setNombre(nombre);
						pacM.setApellidos(apellidos);
						pacM.setEdad(edad);
						pacM.setTelefono(telefono);
						pacM.setHistorial(historial);

						if (pacienteDao.update(pacM)) {
							System.out.println("Pacinete actualizado " + pacM);
						}
					} catch (EmptyResultDataAccessException e) {
						System.out.println("Ese Id de Paciente no existe");
					}
					break;

				case 5: // Eliminar
					int idPac = Integer.parseInt(JOptionPane.showInputDialog("Id Paciente a Eliminar: "));
					try {
						Paciente pacD = pacienteDao.findById(idPac);
						String seg = JOptionPane.showInputDialog("Esta seguro de eliminar al paciente de Id: " + idPac
								+ " de nombre " + pacD.getNombre() + "\n\n");

						if (seg.equalsIgnoreCase("Si")) {
							if (pacienteDao.delete(pacD.getIdPaciente())) {
								System.out.println("Paciente eliminado " + pacD.getNombre());
							}
						}

					} catch (EmptyResultDataAccessException e) {
						System.out.println("Ese Id de Paciente no existe");
					}
					break;
				}

			} while (!salir);

		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("Credenciales, Configuraciones!!");
			e.printStackTrace();
		} catch (DataAccessException e) {
			System.out.println("Error en el SQL");
			e.printStackTrace();
		} catch (NumberFormatException e) {

		}

	}

}
