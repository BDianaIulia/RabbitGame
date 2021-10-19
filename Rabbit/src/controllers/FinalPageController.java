package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import field.BestBasketRole;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FinalPageController implements Initializable, PopUpControllerRole {

	@FXML
	private TextField BestScore;

	@FXML
	private TextField TotalEggs;

	@FXML
	private TextField NumberOfTurns;
	
	@FXML
	private TextField Title;

	@FXML
	private ImageView WinnerImageView;

	@FXML
	private Button BackButton;

	@FXML
	private BorderPane borderPane;

	@FXML
	private VBox box;

	Stage stage;
	private BestBasketRole bestBasket;
	private int numberOfTurns;

	public FinalPageController(BestBasketRole bestBasket, int numberOfTurns) {
		super();
		this.bestBasket = bestBasket;
		this.numberOfTurns = numberOfTurns;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Platform.runLater(() -> {
			borderPane.setStyle("-fx-background-color: rgba(400, 400, 400, 0.2);"
					+ "-fx-background-image: url('/view/goldMedal.png');" + "-fx-background-size: 200,200;"
					+ "-fx-background-repeat: no-repeat;");

			box.getScene().setFill(Color.TRANSPARENT);

			bestBasket.winnerDetails(WinnerImageView, BestScore, TotalEggs);
			NumberOfTurns.setText("in " + Integer.toString(numberOfTurns) + " turns");
			
		});
	}

	@FXML
	private void BackButtonPressed(ActionEvent event) {
		closeStage();
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	private void closeStage() {
		if (stage != null) {
			stage.close();
		}
	}

}
