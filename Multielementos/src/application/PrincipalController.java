package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrincipalController implements Initializable {
	@FXML
	BorderPane root;
	@FXML
	Accordion acordeon;
	@FXML
	TitledPane pSeleccionado;

	private Object cargar(String plantilla) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(plantilla));
			Parent cntr = (Parent) loader.load();
			Object controller = loader.getController();
			root.setCenter(cntr);
			return controller;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void onCalculadoraClick(Event evento) {
		cargar("calculadora.fxml");
	}
	public void onEditorClick(Event evento) {
		EditorController cntr = (EditorController)cargar("editor.fxml");
		cntr.setStage(Main.getStage());
	}
	public void onLimpiaClick(Event evento) {
		limpia();
	}
	public void limpia() {
		root.setCenter(null);
	}
	
	public void onEventosClick(Event evento) {
		EventosController cntr = (EventosController)cargar("eventos.fxml");
		cntr.setOnClose(ev -> limpia());
	}
	public void onEscenaClick() {
		Main.abreEscena("otraEscena.fxml");
	}
	public void onDlgClick() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText("I have a great message for you!");

		alert.showAndWait();

	}
	public void onModalClick() throws IOException {
		Stage dialogStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("dialog.fxml"));
		Parent ventana = (Parent) loader.load();
		((DialogController) loader.getController()).setStage(dialogStage);
		Scene scene = new Scene(ventana, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		dialogStage.setTitle("Child Window");
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(Main.getStage());
		dialogStage.setScene(scene);
		dialogStage.showAndWait();
	}
	public void onModelessClick() throws IOException {
		Stage dialogStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("ventana.fxml"));
		Parent ventana = (Parent) loader.load();
		Scene scene = new Scene(ventana, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		dialogStage.setTitle("Dependiente Window");
		dialogStage.initModality(Modality.NONE);
		dialogStage.initOwner(Main.getStage());
		dialogStage.setScene(scene);
		dialogStage.show();
	}
	public void onIndependienteClick() throws IOException {
		Stage dialogStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("ventana.fxml"));
		Parent ventana = (Parent) loader.load();
		Scene scene = new Scene(ventana, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		dialogStage.setTitle("Independiente Window");
		dialogStage.initModality(Modality.NONE);
		dialogStage.setScene(scene);
		dialogStage.show();
	}
	public void onTextoClick(Event evento) {
		cargar("texto.fxml");
	}
	public void onTextoHTMLClick(Event evento) {
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		root.setCenter(browser);
		StringBuilder sb = new StringBuilder();
		sb.append("<html><body><h1>Titulo del Documento</h1>");
		sb.append("<p><i>Quisque nulla mi, hendrerit id tincidunt id, tincidunt sit amet est. Etiam eget mi quam. Sed mattis enim a dolor luctus feugiat eget sed turpis. Sed placerat facilisis odio eu vestibulum. Donec suscipit ornare lectus. Suspendisse maximus quis magna in pulvinar. Curabitur id volutpat ligula. Mauris sit amet nisl scelerisque, gravida ante id, egestas tellus.</i></p>");
		sb.append("<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus commodo gravida. Nulla facilisi. Integer aliquam tellus sapien, a mattis turpis sagittis eu. Nunc nisl metus, pulvinar in elit semper, fermentum iaculis nunc. Phasellus vitae pellentesque libero. Duis aliquet bibendum tristique. In sit amet varius sem, eu porta massa. Mauris lobortis arcu magna, quis gravida turpis pharetra eget. Proin lorem nibh, ultrices quis rutrum sit amet, luctus accumsan odio. Donec et dui at felis pellentesque volutpat. Ut elit turpis, blandit non ligula vitae, rhoncus dapibus est. Integer nec fringilla odio, in suscipit lorem. Nulla vel nisl nec leo consequat blandit eget at nisi. Nullam a laoreet nunc.</p>");
		sb.append("</body></html>");
		browser.getEngine().loadContent(sb.toString());
	}
	
	public void onNavegaClick(Event evento) {
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load("https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/text-settings.htm#CHDEEAFG");
		//Main.getStage().setTitle(webEngine.getDocument().getDocumentURI());
		root.setCenter(browser);
	}
	public void onIndraClick(Event evento) {
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load("https://www.indracompany.com/");
		//Main.getStage().setTitle(webEngine.getDocument().getDocumentURI());
		root.setCenter(browser);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		acordeon.setExpandedPane(pSeleccionado);
		
	}
}
