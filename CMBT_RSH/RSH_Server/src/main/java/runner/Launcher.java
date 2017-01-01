package runner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Launcher extends Application{

	@Override
	public void start(Stage stage) {
		AnchorPane anchorPane = null;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/服务器界面.fxml"));
			anchorPane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Scene scene = new Scene(anchorPane, 300, 120);
			stage.setTitle("服务器");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 public void startLaunch(String[] args){
	        launch(args);
	 }
}
