package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import builders.BackgroundBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.NextScene;

public class SecondPageController implements Initializable {

	@FXML
	TextField Length_grid;

	int gridLength;
	int windowPrefLength = 400;
	double buttonSize = 40;
	Stage stage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	public void Length_grid_action(ActionEvent event) {

		stage = (Stage) Length_grid.getScene().getWindow();

		gridLength = Integer.parseInt(Length_grid.getText());
		resizeScene();
		// BorderPane root;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/GamePage.fxml"));
			loader.setController(new GamePageController(gridLength, buttonSize));
			Parent layout = loader.load();
			
			BackgroundBuilder background = new BackgroundBuilder("src/view/background.png");
			if (gridLength < 100) {
				NextScene nextScene = new NextScene();
				nextScene.showNewStage(stage, layout, background, windowPrefLength);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void resizeScene() {

		if (gridLength > 12) {
			setSizeWindow(12);
			double maxWidth = windowPrefLength - 200;
			buttonSize = maxWidth / gridLength;

		} else if (gridLength > 5) {
			setSizeWindow(gridLength);
		}

	}

	private void setSizeWindow(int gridLength) {
		int difference = gridLength - 5;

		windowPrefLength += difference * 40;
		stage.setX(stage.getX() - 10 * difference);
		stage.setY(stage.getY() - 10 * difference);
	}

}
