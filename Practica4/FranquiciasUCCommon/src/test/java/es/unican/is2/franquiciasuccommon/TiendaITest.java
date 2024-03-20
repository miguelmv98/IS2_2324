package es.unican.is2.franquiciasuccommon;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TiendaITest {
	
	private Tienda tienda;
	
	@BeforeEach
	public void setUp() {
		tienda = new Tienda("Nombre","Direccion");
	}
	@Test
	public void testConstructor() {
		assertEquals("Nombre",tienda.getNombre());
		assertEquals("Direccion",tienda.getDireccion());
		assertEquals(new LinkedList<Empleado>(),tienda.getEmpleados());
	}
	@Test
	public void testGastoMensualSueldos() {
		
		//Casos validos
		assertEquals(tienda.gastoMensualSueldos(),0.0);
		tienda.getEmpleados().add(new Empleado("123456789A","Nombre1",Categoria.ENCARGADO,LocalDate.now()));
		tienda.getEmpleados().add(new Empleado("123456789B","Nombre2",Categoria.VENDEDOR,LocalDate.now().minusYears(2)));
		assertEquals(tienda.gastoMensualSueldos(),3500);
	}
}
