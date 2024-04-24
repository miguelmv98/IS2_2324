package es.unican.is2.GestionTiendas;

public class VendedorJunior extends Vendedor {
	

	
	private static final double TASA_COMISION_JUNIOR = 0.005;
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorJunior(String nombre, String id, String dni) { //WMC +1
		super(nombre, id, dni,TASA_COMISION_JUNIOR);
	}
}
