package es.unican.is2.GestionTiendas;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class VendedorSeniorTest {
	
	private static VendedorSenior sutSenior;

	
	@BeforeEach
	public void setUp(){
		sutSenior = new VendedorSenior("Pepe", "2", "222222222A");
	}
	
	@Test
	public void testConstructor() {
		assertEquals(sutSenior.getId(), "2");
		assertEquals(sutSenior.getDni(), "222222222A");
		assertEquals(sutSenior.getNombre(), "Pepe");
		assertTrue(sutSenior.getTotalVentas()==0.0);
		assertTrue(sutSenior.getComision()==0.0);
		
	}

	@Test
	public void testAnhadeVenta() {
		
		sutSenior.anhade(300);
		assertEquals(sutSenior.getTotalVentas(), 300, 0);
		assertEquals(sutSenior.getComision(), 3, 0);
		sutSenior.anhade(300);
		assertEquals(sutSenior.getTotalVentas(), 600, 0);
		assertEquals(sutSenior.getComision(), 6, 0);
		sutSenior.anhade(0);
		assertEquals(sutSenior.getTotalVentas(), 600, 0);
		assertEquals(sutSenior.getComision(), 6, 0);
		
	}
	
	@Test
	public void testSetTotalVentas() {

		
		sutSenior.setTotalVentas(4500);
		assertEquals(sutSenior.getTotalVentas(), 4500, 0);		
		sutSenior.setTotalVentas(4000);
		assertEquals(sutSenior.getTotalVentas(), 4000, 0);
		sutSenior.setTotalVentas(0);
		assertEquals(sutSenior.getTotalVentas(), 0, 0);	
		
	}
	
	@Test
	public void testSetComision() {
		
		sutSenior.setComision(4500);
		assertEquals(sutSenior.getComision(), 4500, 0);		
		sutSenior.setComision(4000);
		assertEquals(sutSenior.getComision(), 4000, 0);
		sutSenior.setComision(0);
		assertEquals(sutSenior.getComision(), 0, 0);	
		
	}

	
	@Test
	public void testEquals() {

		VendedorSenior igualSenior = new VendedorSenior("Pepe", "2", "222222222A");
		VendedorSenior distintoIdSenior = new VendedorSenior("Pepe", "3", "222222222A");
		VendedorSenior distintoDNISenior = new VendedorSenior("Pepe", "2", "33333333A");
		
		assertTrue(sutSenior.equals(igualSenior));
		assertFalse(sutSenior.equals(distintoIdSenior));
		assertFalse(sutSenior.equals(distintoDNISenior));
		
		assertFalse(sutSenior.equals(new Object()));
	}
	
	@Test
	public void testHashCode() {
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
