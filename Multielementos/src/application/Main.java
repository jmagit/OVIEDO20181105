package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private static Stage stage;

	public static Stage getStage() {
		return stage;
	}

	public static void abreEscena(String escena) {
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(Main.class.getResource(escena));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
			stage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			abreEscena("Principal.fxml");
			primaryStage.setTitle("Navegacion");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
