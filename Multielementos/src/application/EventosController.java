package application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EventosController {
	@FXML
	Button btnCerra;
	
	private EventHandler<Event> onClose;

	public EventHandler<Event> getOnClose() {
		return onClose;
	}

	public void setOnClose(EventHandler<Event> onClose) {
		this.onClose = onClose;
	}
	
	public void onClick() {
		if(onClose != null)
			onClose.handle(null);
	}
}
