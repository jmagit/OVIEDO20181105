package application;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PrincipalController implements Initializable {
	@FXML
	BorderPane root;
	@FXML
	Accordion acordeon;
	@FXML
	TitledPane pSeleccionado;
	@FXML
	Label valX;
	@FXML
	Label valY;
	@FXML
	Label valData;

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
		EditorController cntr = (EditorController) cargar("editor.fxml");
		cntr.setStage(Main.getStage());
	}

	public void onLimpiaClick(Event evento) {
		limpia();
	}

	public void limpia() {
		root.setCenter(null);
	}

	public void onEventosClick(Event evento) {
		EventosController cntr = (EventosController) cargar("eventos.fxml");
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
		sb.append(
				"<p><i>Quisque nulla mi, hendrerit id tincidunt id, tincidunt sit amet est. Etiam eget mi quam. Sed mattis enim a dolor luctus feugiat eget sed turpis. Sed placerat facilisis odio eu vestibulum. Donec suscipit ornare lectus. Suspendisse maximus quis magna in pulvinar. Curabitur id volutpat ligula. Mauris sit amet nisl scelerisque, gravida ante id, egestas tellus.</i></p>");
		sb.append(
				"<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus commodo gravida. Nulla facilisi. Integer aliquam tellus sapien, a mattis turpis sagittis eu. Nunc nisl metus, pulvinar in elit semper, fermentum iaculis nunc. Phasellus vitae pellentesque libero. Duis aliquet bibendum tristique. In sit amet varius sem, eu porta massa. Mauris lobortis arcu magna, quis gravida turpis pharetra eget. Proin lorem nibh, ultrices quis rutrum sit amet, luctus accumsan odio. Donec et dui at felis pellentesque volutpat. Ut elit turpis, blandit non ligula vitae, rhoncus dapibus est. Integer nec fringilla odio, in suscipit lorem. Nulla vel nisl nec leo consequat blandit eget at nisi. Nullam a laoreet nunc.</p>");
		sb.append("</body></html>");
		browser.getEngine().loadContent(sb.toString());
	}

	public void onListadoClick(Event evento) {
		WebView browser = new WebView();
		root.setCenter(browser);
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head><style>\r\n" + "table {\r\n" + "    border-collapse: collapse;\r\n"
				+ "    width: 100%;\r\n" + "}\r\n" + "\r\n" + "th, td {\r\n" + "    padding: 8px;\r\n"
				+ "    text-align: left;\r\n" + "    border-bottom: 1px solid #ddd;\r\n" + "}\r\n" + "\r\n"
				+ "tr:hover {background-color:#f5f5f5;}\r\n" + "</style></head>");
		sb.append("<body><h1>Listado</h1><table>");

		sb.append("<tr><th>Código</th><th>Nombre</th><th>Apellidos</th></tr>");
		for (int i = 0; i++ < 100;) {
			sb.append(String.format("<tr><td>%d</td><td>Nombre %d</td><td>Apellidos %d</td></tr>", i, i, i));
		}
		sb.append("</table></body></html>");
		browser.getEngine().loadContent(sb.toString());
	}

	public void onNavegaClick(Event evento) {
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load("https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/text-settings.htm#CHDEEAFG");
		// Main.getStage().setTitle(webEngine.getDocument().getDocumentURI());
		root.setCenter(browser);
	}

	public void onIndraClick(Event evento) {
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load("https://www.indracompany.com/");
		// Main.getStage().setTitle(webEngine.getDocument().getDocumentURI());
		root.setCenter(browser);
	}

	public void onVerVideo(Event e) {
		Media media = new Media("https://www.kj.com/sites/default/files/video/530262769.mp4");
		// Media media = new
		// Media("http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv");
		// Media media = new
		// Media(getClass().getResource("mov_bbb.mp4").toExternalForm());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView player = new MediaView(mediaPlayer);
		player.setMediaPlayer(mediaPlayer);
		root.setCenter(player);
		// mediaPlayer.play();
	}

	public void onMediaPlayerClick(Event evento) {
		cargar("video-player.fxml");
	}

	public void onPieClick(Event evento) {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Grapefruit", 13), new PieChart.Data("Oranges", 25), new PieChart.Data("Plums", 10),
				new PieChart.Data("Pears", 22), new PieChart.Data("Apples", 30));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Imported Fruits");
		root.setCenter(chart);
	}

	public void onLineClick(Event evento) {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Month");
		final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

		lineChart.setTitle("Stock Monitoring, 2010");

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("Portfolio 1");

		series1.getData().add(new XYChart.Data("Jan", 23));
		series1.getData().add(new XYChart.Data("Feb", 14));
		series1.getData().add(new XYChart.Data("Mar", 15));
		series1.getData().add(new XYChart.Data("Apr", 24));
		series1.getData().add(new XYChart.Data("May", 34));
		series1.getData().add(new XYChart.Data("Jun", 36));
		series1.getData().add(new XYChart.Data("Jul", 22));
		series1.getData().add(new XYChart.Data("Aug", 45));
		series1.getData().add(new XYChart.Data("Sep", 43));
		series1.getData().add(new XYChart.Data("Oct", 17));
		series1.getData().add(new XYChart.Data("Nov", 29));
		series1.getData().add(new XYChart.Data("Dec", 25));

		XYChart.Series series2 = new XYChart.Series();
		series2.setName("Portfolio 2");
		series2.getData().add(new XYChart.Data("Jan", 33));
		series2.getData().add(new XYChart.Data("Feb", 34));
		series2.getData().add(new XYChart.Data("Mar", 25));
		series2.getData().add(new XYChart.Data("Apr", 44));
		series2.getData().add(new XYChart.Data("May", 39));
		series2.getData().add(new XYChart.Data("Jun", 16));
		series2.getData().add(new XYChart.Data("Jul", 55));
		series2.getData().add(new XYChart.Data("Aug", 54));
		series2.getData().add(new XYChart.Data("Sep", 48));
		series2.getData().add(new XYChart.Data("Oct", 27));
		series2.getData().add(new XYChart.Data("Nov", 37));
		series2.getData().add(new XYChart.Data("Dec", 29));

		XYChart.Series series3 = new XYChart.Series();
		series3.setName("Portfolio 3");
		series3.getData().add(new XYChart.Data("Jan", 44));
		series3.getData().add(new XYChart.Data("Feb", 35));
		series3.getData().add(new XYChart.Data("Mar", 36));
		series3.getData().add(new XYChart.Data("Apr", 33));
		series3.getData().add(new XYChart.Data("May", 31));
		series3.getData().add(new XYChart.Data("Jun", 26));
		series3.getData().add(new XYChart.Data("Jul", 22));
		series3.getData().add(new XYChart.Data("Aug", 25));
		series3.getData().add(new XYChart.Data("Sep", 43));
		series3.getData().add(new XYChart.Data("Oct", 44));
		series3.getData().add(new XYChart.Data("Nov", 45));
		series3.getData().add(new XYChart.Data("Dec", 44));

		lineChart.getData().addAll(series1, series2, series3);
		root.setCenter(lineChart);
	}

	public void onAreaClick(Event evento) {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Month");
		final AreaChart<String, Number> lineChart = new AreaChart<String, Number>(xAxis, yAxis);

		lineChart.setTitle("Stock Monitoring, 2010");

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("Portfolio 1");

		series1.getData().add(new XYChart.Data("Jan", 23));
		series1.getData().add(new XYChart.Data("Feb", 14));
		series1.getData().add(new XYChart.Data("Mar", 15));
		series1.getData().add(new XYChart.Data("Apr", 24));
		series1.getData().add(new XYChart.Data("May", 34));
		series1.getData().add(new XYChart.Data("Jun", 36));
		series1.getData().add(new XYChart.Data("Jul", 22));
		series1.getData().add(new XYChart.Data("Aug", 45));
		series1.getData().add(new XYChart.Data("Sep", 43));
		series1.getData().add(new XYChart.Data("Oct", 17));
		series1.getData().add(new XYChart.Data("Nov", 29));
		series1.getData().add(new XYChart.Data("Dec", 25));

		XYChart.Series series2 = new XYChart.Series();
		series2.setName("Portfolio 2");
		series2.getData().add(new XYChart.Data("Jan", 33));
		series2.getData().add(new XYChart.Data("Feb", 34));
		series2.getData().add(new XYChart.Data("Mar", 25));
		series2.getData().add(new XYChart.Data("Apr", 44));
		series2.getData().add(new XYChart.Data("May", 39));
		series2.getData().add(new XYChart.Data("Jun", 16));
		series2.getData().add(new XYChart.Data("Jul", 55));
		series2.getData().add(new XYChart.Data("Aug", 54));
		series2.getData().add(new XYChart.Data("Sep", 48));
		series2.getData().add(new XYChart.Data("Oct", 27));
		series2.getData().add(new XYChart.Data("Nov", 37));
		series2.getData().add(new XYChart.Data("Dec", 29));

		XYChart.Series series3 = new XYChart.Series();
		series3.setName("Portfolio 3");
		series3.getData().add(new XYChart.Data("Jan", 44));
		series3.getData().add(new XYChart.Data("Feb", 35));
		series3.getData().add(new XYChart.Data("Mar", 36));
		series3.getData().add(new XYChart.Data("Apr", 33));
		series3.getData().add(new XYChart.Data("May", 31));
		series3.getData().add(new XYChart.Data("Jun", 26));
		series3.getData().add(new XYChart.Data("Jul", 22));
		series3.getData().add(new XYChart.Data("Aug", 25));
		series3.getData().add(new XYChart.Data("Sep", 43));
		series3.getData().add(new XYChart.Data("Oct", 44));
		series3.getData().add(new XYChart.Data("Nov", 45));
		series3.getData().add(new XYChart.Data("Dec", 44));

		lineChart.getData().addAll(series1, series2, series3);
		root.setCenter(lineChart);
	}

	public void onStackedAreaChart(Event ev) {
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis(-100, 100, 20);
		xAxis.setLabel("Meses");

		final StackedAreaChart<Number, Number> chart = new StackedAreaChart<Number, Number>(xAxis, yAxis);
		chart.setTitle("Stock Monitoring, 2010");
		chart.setLegendSide(Side.RIGHT);
		chart.getData().add(SerieConNumeros("Manzanas"));
		chart.getData().add(SerieConNumeros("Peras"));
		chart.getData().add(SerieConNumeros("Uvas"));

		chart.getData().stream().forEach((series) -> {
			series.getData().stream().forEach((data) -> {
				data.getNode().addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						valX.setText(Double.toString(e.getX()));
						valY.setText(Double.toString(e.getY()));
						valData.setText(String.valueOf(data.getYValue()) + "%");
					}
				});
			});
		});

		root.setCenter(chart);
		anima2(chart);
	}

	private XYChart.Series SerieConNumeros(String titulo) {
		Random rnd = new Random();
		XYChart.Series series = new XYChart.Series();
		series.setName(titulo);
		for (int i = 1; i <= 12; i++)
			series.getData().add(new XYChart.Data(i, rnd.nextInt() % 100 + 1));
		return series;
	}

	private void anima2(XYChart<Number, Number> chart) {
		Random rnd = new Random();
		Timeline tl = new Timeline();
		tl.getKeyFrames().add(new KeyFrame(Duration.millis(500), (ActionEvent actionEvent) -> {
			chart.getData().stream().forEach((series) -> {
				series.getData().stream().forEach((data) -> {
					int nuevo = rnd.nextInt(100);
					data.setYValue(nuevo);
				});
			});
		}));
		tl.setCycleCount(Animation.INDEFINITE);
		tl.setAutoReverse(true);
		tl.play();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		acordeon.setExpandedPane(pSeleccionado);

	}
}
