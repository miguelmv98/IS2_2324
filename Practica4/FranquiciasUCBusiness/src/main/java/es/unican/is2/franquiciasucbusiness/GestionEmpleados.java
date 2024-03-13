package es.unican.is2.franquiciasucbusiness;

import es.unican.is2.franquiciasuccommon.DataAccessException;
import es.unican.is2.franquiciasuccommon.Empleado;
import es.unican.is2.franquiciasuccommon.IEmpleadosDAO;
import es.unican.is2.franquiciasuccommon.IGestionEmpleados;
import es.unican.is2.franquiciasuccommon.ITiendasDAO;
import es.unican.is2.franquiciasuccommon.OperacionNoValidaException;
import es.unican.is2.franquiciasuccommon.Tienda;



public class GestionEmpleados implements IGestionEmpleados {

	private ITiendasDAO tiendasDAO;
	private IEmpleadosDAO empleadosDAO;
	
	public GestionEmpleados (ITiendasDAO tiendasDAO, IEmpleadosDAO empleadosDAO) {
		this.tiendasDAO = tiendasDAO;
		this.empleadosDAO = empleadosDAO;
	}
	

	public Empleado nuevoEmpleado(Empleado e, String nombre) throws OperacionNoValidaException, DataAccessException {
		long tiendaId= tiendasDAO.tiendaPorNombre(nombre).getId(); //Preparado para anhadir el id de la tienda al empleado		
		return empleadosDAO.crearEmpleado(e);
	}

	public Empleado eliminarEmpleado(String dni, String nombre) throws OperacionNoValidaException, DataAccessException {	
		long tiendaId= tiendasDAO.tiendaPorNombre(nombre).getId(); //Preparado para comprobar si el empleado esta en la tienda 
		return empleadosDAO.eliminarEmpleado(dni);
	}

	public boolean trasladarEmpleado(String dni, String actual, String destino)
			throws OperacionNoValidaException, DataAccessException {
		Tienda tActual= tiendasDAO.tiendaPorNombre(actual); //Preparado para comprobar si el empleado esta en la tienda 
		Tienda tDestino= tiendasDAO.tiendaPorNombre(destino); //Preparado para anhadir el id de la tienda al empleado		
		Empleado empleado = empleadosDAO.empleado(dni); //Preparo empleado para modificar
		if(tActual != null && tDestino != null && empleado != null){
			empleadosDAO.modificarEmpleado(empleado);
			return true;
		}else {
			throw new OperacionNoValidaException("Algun dato no es correcto");
		}
	}

	public Empleado empleado(String dni) throws DataAccessException {
		return empleadosDAO.empleado(dni);
	}

}
