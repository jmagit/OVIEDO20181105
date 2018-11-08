package application;

import application.dal.Empleado;
import application.model.EmpleadoModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface IBaseFormController<M, E> {

	M getModel();

	void setModel(M model);

	void setEntity(E item);

	void setCommand(EventHandler<ActionEvent> accept, EventHandler<ActionEvent> cancel);

}