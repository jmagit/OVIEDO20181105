package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.dal.Empleado;
import application.model.EmpleadoModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EmpleadosFormController extends BaseFormController<EmpleadoModel, Empleado> {
	@FXML
	protected TextField txtId;
	@FXML
	protected TextField txtNombre;
	@FXML
	protected TextField txtApellidos;
	@FXML
	protected ComboBox<String> cbDelegacion;
	@FXML
	protected CheckBox chConflictivo;

	public EmpleadosFormController() {
		super(new EmpleadoModel());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtId.textProperty().bindBidirectional(model.IdEmpleadoProperty());
		txtNombre.textProperty().bindBidirectional(model.NombreProperty());
		txtApellidos.textProperty().bindBidirectional(model.ApellidosProperty());
		cbDelegacion.valueProperty().bindBidirectional(model.DelegacionProperty());
		cbDelegacion.setItems(model.getDelegaciones());
		chConflictivo.selectedProperty().bindBidirectional(model.ConflictivoProperty());
	}


}
