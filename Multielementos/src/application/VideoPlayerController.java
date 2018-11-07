package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoPlayerController implements Initializable {
	@FXML
	private MediaView player;
	@FXML
	private TextField txtURL;
	@FXML
	private Button btnPlay;
	@FXML
	private Button btnPause;
	@FXML
	private Button btnStop;
	
	private Media media;
	private MediaPlayer mediaPlayer;

	public void onLoad(Event evento) {
		if(txtURL.getText().equals("")) return;
		media = new Media(txtURL.getText());
		mediaPlayer = new MediaPlayer(media);
		player.setMediaPlayer(mediaPlayer);
		player.setFitWidth(media.getWidth());
		player.setFitHeight(media.getHeight());
	}
	public void onPlay(Event ev) {
		mediaPlayer.play();
		
	}
	public void onPause(Event ev) {
		mediaPlayer.pause();		
	}
	public void onStop(Event ev) {
		mediaPlayer.stop();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
