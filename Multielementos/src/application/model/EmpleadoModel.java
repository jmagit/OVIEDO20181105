package application.model;

import application.dal.Empleado;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmpleadoModel {
	private SimpleStringProperty idEmpleado = new SimpleStringProperty();
	private SimpleStringProperty nombre = new SimpleStringProperty();
	private SimpleStringProperty apellidos = new SimpleStringProperty();
	private SimpleStringProperty delegacion = new SimpleStringProperty();
	private SimpleBooleanProperty conflictivo = new SimpleBooleanProperty();
	
	public EmpleadoModel() { }
	public EmpleadoModel(Empleado item) { copy(item); }
	
	public int getIdEmpleado() {
		return Integer.parseInt(idEmpleado.get());
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado.set(Integer.toString(idEmpleado));
	}
	public SimpleStringProperty IdEmpleadoProperty() {
		return idEmpleado;
	}
	
	public String getNombre() {
		return nombre.get();
	}
	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}
	public SimpleStringProperty NombreProperty() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos.get();
	}
	public void setApellidos(String apellidos) {
		this.apellidos.set(apellidos);
	}
	public SimpleStringProperty ApellidosProperty() {
		return apellidos;
	}

	public String getDelegacion() {
		return delegacion.get();
	}
	public void setDelegacion(String delegacion) {
		this.delegacion.set(delegacion);
	}
	public SimpleStringProperty DelegacionProperty() {
		return delegacion;
	}

	public boolean isConflictivo() {
		return conflictivo.get();
	}
	public void setConflictivo(boolean conflictivo) {
		this.conflictivo.set(conflictivo);
	}
	public SimpleBooleanProperty ConflictivoProperty() {
		return conflictivo;
	}

	public EmpleadoModel copy(Empleado item) {
		setIdEmpleado(item.getIdEmpleado());
		setNombre(item.getNombre());
		setApellidos(item.getApellidos());
		setDelegacion(item.getDelegacion());
		setConflictivo(item.isConflictivo());
		return this;
	}
	public EmpleadoModel copy(EmpleadoModel item) {
		setIdEmpleado(item.getIdEmpleado());
		setNombre(item.getNombre());
		setApellidos(item.getApellidos());
		setDelegacion(item.getDelegacion());
		setConflictivo(item.isConflictivo());
		return this;
	}
	public Empleado getEmpleado() {
		Empleado rslt = new Empleado();
		rslt.setIdEmpleado(getIdEmpleado());
		rslt.setNombre(getNombre());
		rslt.setApellidos(getApellidos());
		rslt.setDelegacion(getDelegacion());
		rslt.setConflictivo(isConflictivo());
		return rslt;
	}
	
	ObservableList<String> delegaciones = FXCollections.observableArrayList(
			"Madrid", "Oviedo", "Gijon");
	public ObservableList<String> getDelegaciones() { return delegaciones; }

}
