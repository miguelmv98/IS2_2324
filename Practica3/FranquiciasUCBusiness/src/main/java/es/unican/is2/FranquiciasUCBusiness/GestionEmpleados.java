package es.unican.is2.FranquiciasUCBusiness;

import es.unican.is2.FranquiciasUCCommon.DataAccessException;
import es.unican.is2.FranquiciasUCCommon.Empleado;
import es.unican.is2.FranquiciasUCCommon.IEmpleadosDAO;
import es.unican.is2.FranquiciasUCCommon.IGestionEmpleados;
import es.unican.is2.FranquiciasUCCommon.ITiendasDAO;
import es.unican.is2.FranquiciasUCCommon.OperacionNoValidaException;



public class GestionEmpleados implements IGestionEmpleados {

	private ITiendasDAO tiendasDAO;
	private IEmpleadosDAO empleadosDAO;
	
	public GestionEmpleados (ITiendasDAO tiendasDAO, IEmpleadosDAO empleadosDAO) {
		this.tiendasDAO = tiendasDAO;
		this.empleadosDAO = empleadosDAO;
	}
	

	public Empleado nuevoEmpleado(Empleado e, String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Empleado eliminarEmpleado(String dni, String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean trasladarEmpleado(String dni, String actual, String destino)
			throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	public Empleado empleado(String dni) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
