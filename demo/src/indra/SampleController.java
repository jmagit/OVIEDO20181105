package indra;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
	private Button btnEducado;
	@FXML
	private Label lblResultado;
	@FXML
	private Button btn0;
	@FXML
	private TextField txtPropiedad;
	@FXML
	private Label lblPropiedad;
	
	private Persona model = new Persona();
	
	private EventHandler saludarEH, despedirEH;
	
	public void onSaludaClick(ActionEvent ev) {
		lblResultado.setText("Hola " + txtNombre.getText());
		model.setNombre("Hola " + txtNombre.getText());
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
		saludarEH = new EventHandler<Event>()  {
		    public void handle(Event event) {
		    	lblResultado.setText("Hola " + txtNombre.getText());
		    	btnEducado.setText("Despedir");
		    	btnEducado.removeEventHandler(ActionEvent.ACTION, saludarEH);
		    	btnEducado.addEventHandler(ActionEvent.ACTION, despedirEH);
		        event.consume();
		    }
		};
		despedirEH = new EventHandler<Event>()  {
		    public void handle(Event event) {
		    	lblResultado.setText("Adios " + txtNombre.getText());
		    	btnEducado.setText("Saludar");
		    	btnEducado.removeEventHandler(ActionEvent.ACTION, despedirEH);
		    	btnEducado.addEventHandler(ActionEvent.ACTION, saludarEH);
		        event.consume();
		    }
		};
    	btnEducado.setText("Saludar");
    	btnEducado.addEventHandler(ActionEvent.ACTION, saludarEH);

    	txtPropiedad.textProperty().bindBidirectional(model.NombreProperty());
    	lblPropiedad.textProperty().bind(model.NombreProperty());
    	Persona p = new Persona();
    	p.setNombre("Pepito Grillo");
    	model.assign(p);
	}
}
