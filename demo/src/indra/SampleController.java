package indra;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController implements Initializable {
	@FXML
	private TextField txtNombre;
	@FXML
	private Button btnSaluda;
	@FXML
	private Label lblResultado;
	@FXML
	private Button btn0;
	
	public void onSaludaClick(ActionEvent ev) {
		lblResultado.setText("Hola " + txtNombre.getText());
	}

	public void onDespideClick(ActionEvent ev) {
		lblResultado.setText("Adios " + txtNombre.getText());
	}
	public void setNombre(String s) {
		txtNombre.setText(s);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		txtNombre.setText("Oviedo");
//		btnSaluda.setOnAction(e -> { lblResultado.setText("Adios " + txtNombre.getText()); });
		
	}
}
