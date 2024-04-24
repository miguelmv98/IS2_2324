package es.unican.is2.GestionTiendas;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class VendedorJuniorTest {
	
	private static VendedorJunior sutJunior;
	
	@BeforeEach
	public void setUp(){
		sutJunior = new VendedorJunior("Ana", "1", "11111111A");
	}
	
	@Test
	public void testConstructor() {
		assertEquals(sutJunior.getId(), "1");
		assertEquals(sutJunior.getDni(), "11111111A");
		assertEquals(sutJunior.getNombre(), "Ana");
		assertTrue(sutJunior.getTotalVentas()==0.0);
		assertTrue(sutJunior.getComision()==0.0);	
	}

	@Test
	public void testAnhadeVenta() {
	
		sutJunior.anhade(200);
		assertEquals(sutJunior.getTotalVentas(), 200, 0);
		assertEquals(sutJunior.getComision(), 1 ,0);
		sutJunior.anhade(300);
		assertEquals(sutJunior.getTotalVentas(), 500, 0);
		assertEquals(sutJunior.getComision(), 2.5, 0);
		sutJunior.anhade(0);
		assertEquals(sutJunior.getTotalVentas(), 500, 0);
		assertEquals(sutJunior.getComision(), 2.5, 0);
	}
	
	@Test
	public void testSetTotalVentas() {
		
		sutJunior.setTotalVentas(2000);
		assertEquals(sutJunior.getTotalVentas(), 2000, 0);	
		sutJunior.setTotalVentas(4000);
		assertEquals(sutJunior.getTotalVentas(), 4000, 0);	
		sutJunior.setTotalVentas(0);
		assertEquals(sutJunior.getTotalVentas(), 0, 0);
		
	}
	
	@Test
	public void testSetComision() {
		
		sutJunior.setComision(2000);
		assertEquals(sutJunior.getComision(), 2000, 0);	
		sutJunior.setComision(4000);
		assertEquals(sutJunior.getComision(), 4000, 0);	
		sutJunior.setComision(0);
		assertEquals(sutJunior.getComision(), 0, 0);
		
	}

	
	@Test
	public void testEquals() {
		VendedorJunior igualJunior = new VendedorJunior("Ana", "1", "11111111A");
		VendedorJunior distintoIdJunior = new VendedorJunior("Ana", "2", "11111111A");
		VendedorJunior distintoDNIJunior = new VendedorJunior("Ana", "1", "222222222A");
		
		assertTrue(sutJunior.equals(igualJunior));
		assertFalse(sutJunior.equals(distintoIdJunior));
		assertFalse(sutJunior.equals(distintoDNIJunior));
		
		assertFalse(sutJunior.equals(new Object()));
	}
	
	
	
}
