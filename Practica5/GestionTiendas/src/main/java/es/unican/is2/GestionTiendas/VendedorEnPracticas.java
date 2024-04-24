package es.unican.is2.GestionTiendas;

public class VendedorEnPracticas extends Vendedor {
	

	
	private static final double TASA_COMISION_PRACTICAS= 0;
	/**
	 * Retorna un nuevo vendedor en practicas
	 * @param nombre
	 * @param dni
	 */
	public VendedorEnPracticas(String nombre, String id, String dni) { //WMC +1
		super(nombre, id, dni,TASA_COMISION_PRACTICAS);
	}
}
