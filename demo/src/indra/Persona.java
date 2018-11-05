package indra;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {
	private StringProperty nombre = new SimpleStringProperty("(anonimo)");
	
	public String getNombre() { return nombre.get(); }
	public void setNombre(String valor) { nombre.set(valor); }
	public StringProperty NombreProperty() { return nombre; }
	
	public Persona assign(Persona p) {
		this.nombre.set(p.getNombre());
		return this;
	}
}
