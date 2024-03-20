package es.unican.is2.franquiciasucmain;

import static org.junit.jupiter.api.Assertions.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.unican.is2.franquiciasucbusiness.GestionEmpleados;
import es.unican.is2.franquiciasucbusiness.GestionTiendas;
import es.unican.is2.franquiciasucdao.EmpleadosDAO;
import es.unican.is2.franquiciasucdao.TiendasDAO;
import es.unican.is2.franquiciasucgui.VistaGerente;

public class VistaGerenteGUITest {

	private FrameFixture demo;
	
	@BeforeAll
	public void setUp() {
		TiendasDAO tiendasDAO = new TiendasDAO();
		EmpleadosDAO empleadosDAO = new EmpleadosDAO();
		
		// Crear componentes capa negocio
		GestionTiendas gTiendas = new GestionTiendas(tiendasDAO);
		GestionEmpleados gEmpleados = new GestionEmpleados(tiendasDAO, empleadosDAO);
		
		// Crear componentes capa presentacion
		VistaGerente gui = new VistaGerente(gTiendas, gEmpleados);
		demo = new FrameFixture(gui);
		gui.setVisible(true);
	}
	
	@AfterEach
	public void tearDown(){
		demo.cleanUp();
	}
	
	@Test
	public void test() {
		
		// Comprobamos que la interfaz tiene el aspecto deseado
		demo.label("lblNombreTienda").requireText("Nombre Tienda");
		demo.button("btnBuscar").requireText("Buscar");
				
				//  Prueba de saludo con nombre
				// Escribimos un nombre
				// Comprobamos la salida
				
				// Prueba de saludo sin nombre
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	

}
