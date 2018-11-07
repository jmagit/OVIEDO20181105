package application;

import javafx.event.Event;
import javafx.stage.Stage;

public class DialogController {
	private Stage stage;

	public void setStage(Stage escenario) {
		stage = escenario;
	}
	
	public void AceptarClick(Event ev) {
		// ...
		if(stage != null)
			stage.close();
	}
	public void CancelarClick(Event ev) {
		// ...
		if(stage != null)
			stage.close();
	}
}
