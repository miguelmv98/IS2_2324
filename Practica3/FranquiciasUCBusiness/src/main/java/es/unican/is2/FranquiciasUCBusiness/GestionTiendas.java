package es.unican.is2.FranquiciasUCBusiness;

import es.unican.is2.FranquiciasUCCommon.DataAccessException;
import es.unican.is2.FranquiciasUCCommon.IGestionTiendas;
import es.unican.is2.FranquiciasUCCommon.ITiendasDAO;
import es.unican.is2.FranquiciasUCCommon.OperacionNoValidaException;
import es.unican.is2.FranquiciasUCCommon.Tienda;

public class GestionTiendas implements IGestionTiendas {
	
	private ITiendasDAO tiendasDAO;
	
	public GestionTiendas(ITiendasDAO tiendasDAO) {
		this.tiendasDAO = tiendasDAO;
	}

	
	public Tienda nuevaTienda(Tienda t) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Tienda eliminarTienda(String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Tienda tienda(String nombre) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
