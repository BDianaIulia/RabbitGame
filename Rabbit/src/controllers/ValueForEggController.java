package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ValueForEggController implements Initializable {

	@FXML
	private BorderPane borderPaneValue;

	VBox box;
	TextField textField;

	int userEggValue = -1;

	private Stage stage = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Text textArea = new Text("Insert the value of the egg:");
		textArea.setFont(new Font(18));
		VBox textBox = new VBox(textArea);
		textBox.setAlignment(Pos.CENTER);

		BorderPane.setMargin(textBox, new Insets(50));
		borderPaneValue.setTop(textBox);

		textField = new TextField();
		textField.setFont(new Font(18));
		textField.setAlignment(Pos.CENTER);
		textField.setOnAction(eggValueInserted);

		VBox textFieldBox = new VBox(textField);
		textFieldBox.setAlignment(Pos.TOP_CENTER);
		borderPaneValue.setCenter(textFieldBox);

	}

	EventHandler<ActionEvent> eggValueInserted = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {

			userEggValue = Integer.parseInt(textField.getText());
			closeStage();
		}
	};

	public int getResult() {
		return this.userEggValue;
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
