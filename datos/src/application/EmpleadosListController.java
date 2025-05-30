package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.EmpleadoModel;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class EmpleadosListController extends BaseListController<EmpleadoModel> {
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
