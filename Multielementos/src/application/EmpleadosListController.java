package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.EmpleadoModel;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class EmpleadosListController implements Initializable {
	@FXML
	protected Button btnAdd;
	@FXML
	protected Button btnModify;
	@FXML
	protected Button btnRemove;
	@FXML
	protected ListView<EmpleadoModel> lbListado;
	@FXML
	protected TableView<EmpleadoModel> dataGrid;
	
	protected ObservableList<EmpleadoModel> listado;
	protected SimpleObjectProperty<EmpleadoModel> elemento;

	public ObservableList<EmpleadoModel> getListado() {
		return listado;
	}
	public void setListado(ObservableList<EmpleadoModel> listado) {
		this.listado = listado;
		if (lbListado != null)
			lbListado.setItems(this.listado);
	}
	public EmpleadoModel getElemento() {
		return elemento.get();
	}
	public void setCommand(EventHandler<ActionEvent> add, EventHandler<ActionEvent> modify,
			EventHandler<ActionEvent> remove) {
		if (btnAdd != null)
			btnAdd.setOnAction(add);
		if (btnModify != null)
			btnModify.setOnAction(modify);
		if (btnRemove != null)
			btnRemove.setOnAction(remove);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		elemento = new SimpleObjectProperty<EmpleadoModel>();
		if (lbListado != null) {
			lbListado.setCellFactory(new Callback<ListView<EmpleadoModel>, ListCell<EmpleadoModel>>() {
				@Override
				public ListCell<EmpleadoModel> call(ListView<EmpleadoModel> param) {
					return new ListCell<EmpleadoModel>() {
						@Override
						protected void updateItem(EmpleadoModel item, boolean empty) {
							super.updateItem(item, empty);
							if (item != null) {
								setText(String.format("%s %s (%d)", item.getNombre(), item.getApellidos(), item.getIdEmpleado()));
							} else {
								setText(null);
							}
						}
					};
				}
			});
			elemento.bind(lbListado.getSelectionModel().selectedItemProperty());
		}	}

}
