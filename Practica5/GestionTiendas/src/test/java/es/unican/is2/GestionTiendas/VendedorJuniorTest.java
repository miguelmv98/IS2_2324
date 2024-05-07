package es.unican.is2.GestionTiendas;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class VendedorJuniorTest {
	
	private static VendedorJunior sutJunior;
	
	@BeforeEach
	void setUp(){
		sutJunior = new VendedorJunior("Ana", "1", "11111111A");
	}
	
	@Test
	void testConstructor() {
		assertEquals("1", sutJunior.getId());
		assertEquals("11111111A", sutJunior.getDni());
		assertEquals("Ana", sutJunior.getNombre());
		assertEquals(0.0,sutJunior.getTotalVentas());
		assertEquals(0.0, sutJunior.getComision());	
	}

	@Test
	void testAnhadeVenta() {
	
		sutJunior.anhade(200);
		assertEquals(200.0, sutJunior.getTotalVentas());
		assertEquals(1.0, sutJunior.getComision());
		sutJunior.anhade(300);
		assertEquals(500.0, sutJunior.getTotalVentas());
		assertEquals(2.5, sutJunior.getComision());
		sutJunior.anhade(0);
		assertEquals(500.0, sutJunior.getTotalVentas());
		assertEquals(2.5, sutJunior.getComision());
	}
	
	@Test
	void testSetTotalVentas() {
		
		sutJunior.setTotalVentas(2000);
		assertEquals(2000.0, sutJunior.getTotalVentas());	
		sutJunior.setTotalVentas(4000);
		assertEquals(4000.0, sutJunior.getTotalVentas());	
		sutJunior.setTotalVentas(0);
		assertEquals(0.0, sutJunior.getTotalVentas());
		
	}
	
	@Test
	void testSetComision() {
		
		sutJunior.setComision(2000);
		assertEquals(2000.0, sutJunior.getComision());	
		sutJunior.setComision(4000);
		assertEquals(4000.0, sutJunior.getComision());	
		sutJunior.setComision(0);
		assertEquals(0.0, sutJunior.getComision());
		
	}

	
	@Test
	void testEquals() {
		VendedorJunior igualJunior = new VendedorJunior("Ana", "1", "11111111A");
		VendedorJunior distintoIdJunior = new VendedorJunior("Ana", "2", "11111111A");
		VendedorJunior distintoDNIJunior = new VendedorJunior("Ana", "1", "222222222A");
		
		assertEquals(igualJunior,sutJunior);
		assertNotEquals(distintoIdJunior, sutJunior);
		assertNotEquals(distintoDNIJunior,sutJunior);
		
		assertNotEquals(new Object(), sutJunior);
	}
	
	
	
}
