package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import application.Loader;
import builders.BackgroundBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.NextScene;

public class FirstPageController implements Initializable {

	@FXML
	private Button Start_button;

	@FXML
	private Button Info_button;
	
	@FXML
	private Button ResumeButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		File tempFile = new File("saveGame.txt");
		boolean exists = tempFile.exists();
		
		if(!exists)
			ResumeButton.setDisable(true);
		
		
		
	}

	@FXML
	private void Start_button_pressed(ActionEvent event) {
		Stage stage = (Stage) Start_button.getScene().getWindow();

		GridPane root;
		try {

			root = (GridPane) FXMLLoader.load(getClass().getResource("/fxml/SecondPage.fxml"));

			BackgroundBuilder background = new BackgroundBuilder("src/view/background.png");
			NextScene nextScene = new NextScene();
			nextScene.showNewStage(stage, root, background, 400);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	private void ResumeButtonPressed(ActionEvent event) throws IOException, ClassNotFoundException {
		
		FileInputStream fin = new FileInputStream("saveGame.txt");

		ObjectInputStream in = new ObjectInputStream(fin);
		
		Loader newLoader = ((Loader)in.readObject());
		
		in.close();
		
		newLoader.setStage((Stage) Start_button.getScene().getWindow());
	
		
		newLoader.loadGame();
	}
	
	@FXML
	private void Info_button_pressed(ActionEvent event)
	{
		
		showPopupWindow();
	}
	
	public void showPopupWindow() {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/InfoWindow.fxml"));
		
		loader.setController(new InfoPopupController());
		Parent layout;

		try {
			layout = loader.load();

			Stage popupStage = new Stage();
			
			popupStage.initOwner((Stage) Start_button.getScene().getWindow());
			popupStage.initModality(Modality.WINDOW_MODAL);

			BackgroundBuilder background = new BackgroundBuilder("src/view/background2.jpg");

			NextScene nextScene = new NextScene();
			nextScene.showAndWaitNewStage(popupStage, layout, background, 400);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
