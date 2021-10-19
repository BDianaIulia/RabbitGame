package application;
	
import java.io.Serializable;

import builders.BackgroundBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.NextScene;



public class Main extends Application implements Serializable {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/fxml/FirstPage.fxml"));
			
			BackgroundBuilder background = new BackgroundBuilder("src/view/background.png");
			NextScene nextScene = new NextScene();
			nextScene.showNewStage(primaryStage, root, background, 400);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
