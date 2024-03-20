package es.unican.is2.franquiciasuccommon;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.*;

public class EmpleadoTest {
	
	private Empleado empleado;
	
	@BeforeEach
	public void setUp() {
		empleado = new Empleado("12345678A","Nombre",Categoria.ENCARGADO,LocalDate.now());
	}
	@Test
	public void testConstructor() {
		assertEquals("12345678A",empleado.getDNI());
		assertEquals("Nombre",empleado.getNombre());
		assertEquals(Categoria.ENCARGADO,empleado.getCategoria());
		assertEquals(LocalDate.now(),empleado.getFechaContratacion());
	}

	@Test
	public void testSueldoBruto() {
		assertDoesNotThrow(() -> {
		//Casos Validos
		caseTestSueldoBruto(Categoria.ENCARGADO, LocalDate.now(),false,2000);
		caseTestSueldoBruto(Categoria.VENDEDOR, LocalDate.now().minusYears(2),false,1500);
		caseTestSueldoBruto(Categoria.AUXILIAR, LocalDate.now().minusYears(5),false,1000);
		caseTestSueldoBruto(Categoria.ENCARGADO, LocalDate.now().minusYears(5).minusDays(1),false,2050);
		caseTestSueldoBruto(Categoria.ENCARGADO, LocalDate.now().minusYears(7),true,2050*0.75);
		caseTestSueldoBruto(Categoria.VENDEDOR, LocalDate.now().minusYears(10),false,1550);
		caseTestSueldoBruto(Categoria.VENDEDOR, LocalDate.now().minusYears(10).minusDays(1),false,1600);
		caseTestSueldoBruto(Categoria.AUXILIAR, LocalDate.now().minusYears(15),false,1100);
		caseTestSueldoBruto(Categoria.AUXILIAR, LocalDate.now().minusYears(20),true,1100*0.75);
		caseTestSueldoBruto(Categoria.ENCARGADO, LocalDate.now().minusYears(20).minusDays(1),true,2200*0.75);
		caseTestSueldoBruto(Categoria.VENDEDOR, LocalDate.now().minusYears(45),false,1700);
		});
		
		//Casos No Validos
		empleado.setCategoria(null);
		assertThrows(NullPointerException.class,()->empleado.sueldoBruto());
		
		empleado.setCategoria(Categoria.ENCARGADO);
		empleado.setFechaContratacion(LocalDate.now().plusDays(1));
		assertThrows(Exception.class,()->empleado.sueldoBruto());
		
		empleado.setFechaContratacion(null);
		assertThrows(NullPointerException.class,()->empleado.sueldoBruto());
		
		caseTestSueldoBruto(Categoria.OTRO, LocalDate.now(),false,0);
	}
	
	private void caseTestSueldoBruto(Categoria categoria, LocalDate fechaContratacion, boolean baja, double resultadoEsperado) {
		empleado.setCategoria(categoria);
		empleado.setFechaContratacion(fechaContratacion);
		if(baja) { empleado.darDeBaja(); }
		else if(empleado.getBaja()) {empleado.darDeAlta();}
		try {
			assertEquals(resultadoEsperado,empleado.sueldoBruto());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
