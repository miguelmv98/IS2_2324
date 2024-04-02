package es.unican.is2.franquiciasucmain;

import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import es.unican.is2.franquiciasucbusiness.GestionEmpleados;
import es.unican.is2.franquiciasucbusiness.GestionTiendas;
import es.unican.is2.franquiciasucdao.EmpleadosDAO;
import es.unican.is2.franquiciasucdao.TiendasDAO;
import es.unican.is2.franquiciasucgui.VistaGerente;

public class VistaGerenteGUITest {

	private static FrameFixture demo;
	
	@BeforeAll
	public static void setUp() {
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
		demo.label("lblDatosTienda").requireText("Datos Tienda");
		demo.label("lblNombreContribuyente").requireText("Direccion");
		demo.label("lblEmpleados").requireText("Empleados");
		demo.label("lblTotalSueldos").requireText("Total sueldos");
		demo.button("btnBuscar").requireText("Buscar");	
	
		
		demo.textBox("txtNombreTienda").enterText("Tienda A");
		demo.button("btnBuscar").click();
		
		demo.textBox("txtDireccionTienda").requireText("Direccion A");
		demo.list("listNombreEmpleados").requireItemCount(3);
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		demo.textBox("txtNombreTienda").setText("");
		demo.textBox("txtNombreTienda").enterText("Tienda C");
		demo.button("btnBuscar").click();
		
		demo.textBox("txtDireccionTienda").requireText("Direccion C");
		demo.list("listNombreEmpleados").requireItemCount(0);
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	

		demo.textBox("txtNombreTienda").setText("");
		demo.textBox("txtNombreTienda").enterText("Tienda D");
		demo.button("btnBuscar").click();
		
		demo.textBox("txtDireccionTienda").requireText("Tienda No Existe");
		demo.list("listNombreEmpleados").requireItemCount(0);
		
		// Sleep para visualizar como se realiza el test
		try {demo.textBox("txtNombreTienda").setText("");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	

		demo.textBox("txtNombreTienda").setText(null);
		demo.button("btnBuscar").click();
		
		demo.textBox("txtDireccionTienda").requireText("Tienda No Existe");
		demo.list("listNombreEmpleados").requireItemCount(0);
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		demo.textBox("txtNombreTienda").setText("");
		demo.textBox("txtNombreTienda").enterText(" ! 'Tienda A'");
		demo.button("btnBuscar").click();
		
		demo.textBox("txtDireccionTienda").requireText("Error acceso a datos");
		demo.list("listNombreEmpleados").requireItemCount(0);
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
}
