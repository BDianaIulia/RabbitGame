package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Pop_upPauseAndSaveController implements Initializable, PopUpControllerRole {

	private Stage stage;
	private boolean wasSaved = false;

	@FXML
	BorderPane borderPane;

	@FXML
	Button SaveButton;

	@FXML
	AnchorPane anchorPane;

	@FXML
	VBox box;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		Platform.runLater(() -> {
			borderPane.setStyle("-fx-background-color: rgba(400, 400, 400, 0.5);"
					+ "-fx-effect: dropshadow(gaussian, lightgreen, 20, 0, 10, 10);" + "-fx-background-insets: 50;");

			box.setStyle("-fx-background-color: transparent;");
			anchorPane.setStyle("-fx-background-color: transparent;");

			box.getScene().setFill(Color.TRANSPARENT);
		});
	}

	@FXML
	private void ContinueButtonPressed(ActionEvent event) {
		closeStage();
	}

	@FXML
	private void SaveButtonPressed(ActionEvent event) {
		wasSaved = true;
		SaveButton.setDisable(true);
	}

	public boolean getResult() {
		return this.wasSaved;
	}

	@Override
	public void setStage(Stage popupStage) {
		stage = popupStage;
	}

	private void closeStage() {
		if (stage != null) {
			stage.close();
		}
	}

}
