package application;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public abstract class BaseListController<M> implements Initializable {
	@FXML
	protected Button btnAdd;
	@FXML
	protected Button btnModify;
	@FXML
	protected Button btnRemove;
	@FXML
	protected ListView<M> lbListado;
	protected ObservableList<M> listado;
	protected SimpleObjectProperty<M> elemento;

	public BaseListController() {
		super();
	}

	public ObservableList<M> getListado() {
		return listado;
	}

	public void setListado(ObservableList<M> listado) {
		this.listado = listado;
		if (lbListado != null)
			lbListado.setItems(this.listado);
	}

	public M getElemento() {
		return elemento.get();
	}

	public void setCommand(EventHandler<ActionEvent> add, EventHandler<ActionEvent> modify, EventHandler<ActionEvent> remove) {
		if (btnAdd != null)
			btnAdd.setOnAction(add);
		if (btnModify != null)
			btnModify.setOnAction(modify);
		if (btnRemove != null)
			btnRemove.setOnAction(remove);
	}

}