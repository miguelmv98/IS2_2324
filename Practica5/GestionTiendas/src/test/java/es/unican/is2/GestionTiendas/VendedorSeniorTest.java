package es.unican.is2.GestionTiendas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class VendedorSeniorTest {
	
	private static VendedorSenior sutSenior;

	
	@BeforeEach
	void setUp(){
		sutSenior = new VendedorSenior("Pepe", "2", "222222222A");
	}
	
	@Test
	void testConstructor() {
		assertEquals("2", sutSenior.getId());
		assertEquals("222222222A", sutSenior.getDni());
		assertEquals("Pepe", sutSenior.getNombre());
		assertEquals(0.0, sutSenior.getTotalVentas());
		assertEquals(0.0, sutSenior.getComision());
		
	}

	@Test
	void testAnhadeVenta() {
		
		sutSenior.anhade(300);
		assertEquals(300.0, sutSenior.getTotalVentas());
		assertEquals(3.0, sutSenior.getComision());
		sutSenior.anhade(300);
		assertEquals(600.0, sutSenior.getTotalVentas());
		assertEquals(6.0, sutSenior.getComision());
		sutSenior.anhade(0);
		assertEquals(600.0, sutSenior.getTotalVentas());
		assertEquals(6.0, sutSenior.getComision());
		
	}
	
	@Test
	void testSetTotalVentas() {

		
		sutSenior.setTotalVentas(4500);
		assertEquals(4500.0, sutSenior.getTotalVentas());		
		sutSenior.setTotalVentas(4000);
		assertEquals(4000.0, sutSenior.getTotalVentas());
		sutSenior.setTotalVentas(0);
		assertEquals(0.0, sutSenior.getTotalVentas());	
		
	}
	
	@Test
	void testSetComision() {
		
		sutSenior.setComision(4500);
		assertEquals(4500.0, sutSenior.getComision());		
		sutSenior.setComision(4000);
		assertEquals(4000.0, sutSenior.getComision());
		sutSenior.setComision(0);
		assertEquals(0.0, sutSenior.getComision());	
		
	}

	
	@Test
	void testEquals() {

		VendedorSenior igualSenior = new VendedorSenior("Pepe", "2", "222222222A");
		VendedorSenior distintoIdSenior = new VendedorSenior("Pepe", "3", "222222222A");
		VendedorSenior distintoDNISenior = new VendedorSenior("Pepe", "2", "33333333A");
		
		assertEquals(igualSenior, sutSenior);
		assertNotEquals(distintoIdSenior, sutSenior);
		assertNotEquals(distintoDNISenior,sutSenior);
		
		assertNotEquals(new Object(),sutSenior);
	}
	
	@Test
	void testHashCode() {
		VendedorSenior igualSenior = new VendedorSenior("Pepe", "2", "222222222A");
		VendedorSenior distintoIdSenior = new VendedorSenior("Pepe", "3", "222222222A");
		VendedorSenior distintoDNISenior = new VendedorSenior("Pepe", "2", "33333333A");
		VendedorSenior distintoSinIdSenior = new VendedorSenior("Pepe", null, "33333333A");
		
		assertEquals(igualSenior.hashCode(),sutSenior.hashCode());
		assertNotEquals(distintoIdSenior.hashCode(),sutSenior.hashCode());
		assertEquals(distintoDNISenior.hashCode(),sutSenior.hashCode());
		assertNotEquals(distintoSinIdSenior.hashCode(),sutSenior.hashCode());
		
		assertNotEquals(new Object().hashCode(),sutSenior.hashCode());
	}
	
	
	
}
