package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import builders.BackgroundBuilder;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NextScene implements Serializable{

	private Stage prepareScene(Stage stage, Parent root, BackgroundBuilder background, int height) {
		try {
			background.setBackground((Pane) root);
			Scene scene = new Scene(root, height, height);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			stage.setScene(scene);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stage;
	}
	
	public void showNewStage(Stage stage, Parent root, BackgroundBuilder background, int height)
	{
		prepareScene(stage, root, background, height).show();
	}
	
	public void showAndWaitNewStage(Stage stage, Parent root, BackgroundBuilder background, int height)
	{
		prepareScene(stage, root, background, height).showAndWait();
	}
}
