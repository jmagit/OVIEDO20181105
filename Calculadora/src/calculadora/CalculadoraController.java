package calculadora;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculadoraController implements Initializable {
    private Calculadora calculadora = new Calculadora();
    private boolean limpia = true;
    @FXML
    private Label txtPantalla;
    
    private StringProperty pantalla = new SimpleStringProperty("0");

    public void DigitoPulsado(ActionEvent e) throws CalculadoraException {
        String d = (String) ((Button) e.getSource()).getText();
        String s = pantalla.get();
        if(d == null || d.length() != 1 || "0".compareTo(d) == 1 || "9".compareTo(d) == -1) 
        	throw new CalculadoraException("No es un digito.");
        if(s.equals("0") || limpia) {
            s = "";
            limpia = false;
        }
        pantalla.set(s + d);
    }

    public void OperacionPulsada(ActionEvent e) {
        try {
            char op = ((Button) e.getSource()).getText().charAt(0);
            ponResultadoFormateado(calculadora.calcula(pantalla.get(), op));
            limpia = true;
        } catch(CalculadoraException ex) {
            muestraExcepcion(ex);
        }
    }

    public void btnIni(ActionEvent e) {
        calculadora.inicializa();
        pantalla.set("0");
    }

    public void btnDecimal(ActionEvent e) {
        String s = pantalla.get();
        if(limpia) {
            pantalla.set("0,");
            limpia = false;
        } else if(s.indexOf(',') == -1) {
            pantalla.set(s + ",");
        }
    }

    public void btnSigno(ActionEvent e) {
        ponResultadoFormateado(-1 * dameOperandoDePantalla());
        if (limpia) calculadora.cambiaSigno();
    }

    public void btnBorra(ActionEvent e) {
        String s = pantalla.get();
        if(limpia || s.length() == 1 || s.equals("0,")) {
            pantalla.set("0");
            limpia = false;
        } else {
            pantalla.set(s.substring(0, s.length() - 1));
        }
    }
    private void ponResultadoFormateado(double rslt) {
        String s = Double.toString(rslt);
        if(s.endsWith(".0")) {
        	pantalla.set(s.replace(".0", ""));
        } else {
        	pantalla.set(s.replace(".", ","));
        }
    }

    private double dameOperandoDePantalla() {
        String operando2 = txtPantalla.getText();
        if(operando2.endsWith(",")) {
            operando2 += "0";
        }
        return Double.parseDouble(operando2.replace(',', '.'));
    }

    private void muestraExcepcion(CalculadoraException ex) {
    	Alert dlg = new Alert(AlertType.ERROR, ex.getMessage());
    	dlg.showAndWait();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtPantalla.textProperty().bindBidirectional(pantalla);
		
	}

}