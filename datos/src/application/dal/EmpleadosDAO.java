package application.dal;

import java.io.IOException;
import java.util.Collection;
import java.util.Hashtable;


public class EmpleadosDAO {
	private static Hashtable<Integer, Empleado> listado = new Hashtable<Integer, Empleado>();
	static {
		listado.put(1, new Empleado(1, "Pepito", "Grillo", "Madrid", true));
		listado.put(2, new Empleado(2, "Carmelo", "Coton", "A Coruña", false));
	}
	
	public Collection<Empleado> getAll() {
		return listado.values();
	}
	
	public Empleado get(int key) throws IOException {
		if(0>key || key>listado.size() )
			throw new IOException("No encontrado.");
		Empleado rslt = listado.get(key);
		if(rslt == null)
			throw new IOException("No encontrado.");
		return rslt;
	}
	public Empleado insert(Empleado item) throws IOException {
		if(item == null)
			throw new IOException("Argumentos invalidos.");
		Empleado rslt = listado.get(item.getIdEmpleado());
		if(rslt != null)
			throw new IOException("Clave duplicada.");
		if(item.isInvalid())
			throw new IOException("Error en datos.");
		listado.put(item.getIdEmpleado(), item);
		return rslt;
	}
	public Empleado update(Empleado item) throws IOException {
		Empleado rslt = listado.get(item.getIdEmpleado());
		if(rslt == null)
			throw new IOException("No encontrado.");
		if(item.isInvalid())
			throw new IOException("Error en datos.");
		listado.put(item.getIdEmpleado(), item);
		return rslt;
	}
	public Empleado delete(int key) throws IOException {
		Empleado rslt = listado.get(key);
		if(rslt == null)
			throw new IOException("No encontrado.");
		listado.remove(key);
		return rslt;
	}
}
