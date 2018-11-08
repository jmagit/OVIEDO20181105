package application;

import application.dal.Empleado;
import application.model.EmpleadoModel;
import application.model.ModelCopiable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public abstract class BaseFormController<M extends ModelCopiable, E> implements IBaseFormController<M, E>, Initializable {
	@FXML
	protected Button btnAccept;
	@FXML
	protected Button btnCancel;

	M model;
	
	public BaseFormController(M model) {
		super();
		this.model = model;
	}

	@Override
	public M getModel() {
		return model;
	}

	@Override
	public void setModel(M model) {
		this.model.copyEntity(model);
	}

	@Override
	public void setEntity(E item) {
		this.model.copyEntity(item);
	}

	@Override
	public void setCommand(EventHandler<ActionEvent> accept, EventHandler<ActionEvent> cancel) {
		if(btnAccept != null) btnAccept.setOnAction(accept);
		if(btnCancel != null) btnCancel.setOnAction(cancel);
	}

}