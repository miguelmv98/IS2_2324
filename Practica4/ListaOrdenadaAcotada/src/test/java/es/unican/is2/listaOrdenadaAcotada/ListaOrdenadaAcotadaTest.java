package es.unican.is2.listaOrdenadaAcotada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ListaOrdenadaAcotadaTest {
	
	private ListaOrdenadaAcotada<Integer> listaVaciaTam10;
	private ListaOrdenadaAcotada<Integer> lista1234Tam5;
	private ListaOrdenadaAcotada<Integer> lista111Tam5;
	
	@BeforeEach
	public void setUp() {
		listaVaciaTam10 = new ListaOrdenadaAcotada<Integer>(10);
		lista1234Tam5 = new ListaOrdenadaAcotada<Integer>(5);
		lista1234Tam5.add(1);
		lista1234Tam5.add(2);
		lista1234Tam5.add(3);
		lista1234Tam5.add(4);
		lista111Tam5 = new ListaOrdenadaAcotada<Integer>(5);
		lista111Tam5.add(1);
		lista111Tam5.add(1);
		lista111Tam5.add(1);
	}
	@Test
	public void testConstructor() {
		
		//Casos de prueba validos
		ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>(1);
		assertEquals(lista.size(), 0);
		ListaOrdenadaAcotada<Integer> lista2 = new ListaOrdenadaAcotada<Integer>(20);
		assertEquals(lista2.size(), 0);
		ListaOrdenadaAcotada<Integer> lista3 = new ListaOrdenadaAcotada<Integer>(20);
		assertEquals(lista3.size(), 0);
		
		assertEquals(lista111Tam5.size(),3);
		
		//Casos de prueba no validos
		assertThrows(NegativeArraySizeException.class,() -> new ListaOrdenadaAcotada<Integer>(-1));
		assertThrows(NegativeArraySizeException.class,() -> new ListaOrdenadaAcotada<Integer>(-15));
	}
	@Test
	public void testSize() {
		//Casos de prueba validos
		assertEquals(listaVaciaTam10.size(), 0);
		assertEquals(lista1234Tam5.size(),4);
	}
	@Test
	public void testGet() {
		
		//Casos de prueba validos
		assertEquals(lista1234Tam5.get(0),1);
		assertEquals(lista1234Tam5.get(2),3);
		assertEquals(lista1234Tam5.get(3),4);
		
		//Casos de prueba no validos
		assertThrows(IndexOutOfBoundsException.class,() ->listaVaciaTam10.get(0));
		assertThrows(IndexOutOfBoundsException.class,() ->lista1234Tam5.get(-1));
		assertThrows(IndexOutOfBoundsException.class,() ->lista1234Tam5.get(-15));
		assertThrows(IndexOutOfBoundsException.class,() ->lista1234Tam5.get(4));
		assertThrows(IndexOutOfBoundsException.class,() ->lista1234Tam5.get(20));
		
		
	}
	@Test
	public void testAdd() {
		
		//Casos de prueba validos
		assertDoesNotThrow(() -> {
		assertEquals(listaVaciaTam10.size(),0);
		listaVaciaTam10.add(0);
		assertEquals(listaVaciaTam10.size(),1);
		assertEquals(listaVaciaTam10.get(0),0);
		
		lista1234Tam5.add(5);
		assertEquals(lista1234Tam5.size(),5);
		
		listaVaciaTam10.add(20);
		assertEquals(listaVaciaTam10.get(1),20);
		
		listaVaciaTam10.add(-20);
		assertEquals(listaVaciaTam10.get(0),-20);
		
		listaVaciaTam10.add(-1);

		assertEquals(listaVaciaTam10.size(),4);
		assertEquals(listaVaciaTam10.get(0),-20);
		assertEquals(listaVaciaTam10.get(1),-1);
		assertEquals(listaVaciaTam10.get(2),0);
		assertEquals(listaVaciaTam10.get(3),20);
		
		listaVaciaTam10.add(20);

		assertEquals(listaVaciaTam10.size(),5);
		assertEquals(listaVaciaTam10.get(0),-20);
		assertEquals(listaVaciaTam10.get(1),-1);
		assertEquals(listaVaciaTam10.get(2),0);
		assertEquals(listaVaciaTam10.get(3),20);
		assertEquals(listaVaciaTam10.get(4),20);
		
		lista111Tam5.add(7);
		assertEquals(lista111Tam5.size(),4);
		assertEquals(lista111Tam5.get(0),1);
		assertEquals(lista111Tam5.get(3),7);
		});
		//Casos de prueba no validos
		
		assertThrows(NullPointerException.class,()->listaVaciaTam10.add(null));
		assertEquals(listaVaciaTam10.size(),5);
		assertThrows(IllegalStateException.class,()->lista1234Tam5.add(20));
		assertEquals(lista1234Tam5.size(),5);
		assertEquals(lista1234Tam5.get(0),1);
		assertEquals(lista1234Tam5.get(1),2);
		assertEquals(lista1234Tam5.get(2),3);
		assertEquals(lista1234Tam5.get(3),4);
		assertEquals(lista1234Tam5.get(4),5);
		assertThrows(IllegalStateException.class,()->lista1234Tam5.add(1));
		
		
	}
	@Test
	public void testRemove() {
		
		//Casos de prueba validos

		assertEquals(lista1234Tam5.size(),4);
		assertEquals(lista1234Tam5.remove(3),4);
		assertEquals(lista1234Tam5.size(),3);
		assertEquals(lista1234Tam5.get(1),2);
		
		assertEquals(lista1234Tam5.remove(2),3);
		assertEquals(lista1234Tam5.size(),2);
		
		assertEquals(lista1234Tam5.remove(0),1);
		assertEquals(lista1234Tam5.size(),1);
		assertEquals(lista1234Tam5.get(0),1);		

		//Casos de prueba no validos
		assertThrows(IndexOutOfBoundsException.class,() ->listaVaciaTam10.remove(0));
		assertThrows(IndexOutOfBoundsException.class,() ->lista1234Tam5.remove(-1));
		assertThrows(IndexOutOfBoundsException.class,() ->lista1234Tam5.remove(-15));
		assertThrows(IndexOutOfBoundsException.class,() ->lista1234Tam5.remove(4));
		assertThrows(IndexOutOfBoundsException.class,() ->lista1234Tam5.remove(20));
				
	}
	@Test
	public void testClear() {
		//Casos de prueba validos
		assertEquals(lista1234Tam5.size(),4);
		lista1234Tam5.clear();
		assertEquals(lista1234Tam5.size(),0);
		assertEquals(listaVaciaTam10.size(), 0);
		listaVaciaTam10.clear();
		assertEquals(listaVaciaTam10.size(), 0);
		
	}

}
