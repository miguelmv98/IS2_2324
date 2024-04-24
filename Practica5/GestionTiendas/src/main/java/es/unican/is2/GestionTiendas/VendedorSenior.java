package es.unican.is2.GestionTiendas;

public class VendedorSenior extends Vendedor {
	
	private static final double TASA_COMISION_SENIOR = 0.01;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorSenior(String nombre, String id, String dni) { // WMC +1
		super(nombre, id, dni, TASA_COMISION_SENIOR);
	}
	
}
