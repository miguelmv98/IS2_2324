package es.unican.is2.franquiciasucbusiness;

import es.unican.is2.franquiciasuccommon.DataAccessException;
import es.unican.is2.franquiciasuccommon.IGestionTiendas;
import es.unican.is2.franquiciasuccommon.ITiendasDAO;
import es.unican.is2.franquiciasuccommon.OperacionNoValidaException;
import es.unican.is2.franquiciasuccommon.Tienda;

public class GestionTiendas implements IGestionTiendas {
	
	private ITiendasDAO tiendasDAO;
	
	public GestionTiendas(ITiendasDAO tiendasDAO) {
		this.tiendasDAO = tiendasDAO;
	}

	
	public Tienda nuevaTienda(Tienda t) throws DataAccessException {
		return tiendasDAO.crearTienda(t);
	}

	
	public Tienda eliminarTienda(String nombre) throws OperacionNoValidaException, DataAccessException {
		Tienda tienda = tiendasDAO.tiendaPorNombre(nombre);
		if(!tienda.getEmpleados().isEmpty()) {
			throw new OperacionNoValidaException("La tienda aun tiene empleados");
		}
		long id = tiendasDAO.tiendaPorNombre(nombre).getId();
		return tiendasDAO.eliminarTienda(id);
	}

	
	public Tienda tienda(String nombre) throws DataAccessException {
		return tiendasDAO.tiendaPorNombre(nombre);
	}

}
