package controllers;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.Model;
import view.ModelRole;

public class Pop_upRabbitController implements Initializable, PopUpControllerRole {

	private Stage stage = null;
	private ModelRole result;
	@FXML
	private BorderPane Border_pane_rabbits;

	Map<String, ModelRole> listOfRabbits;
	ListView<String> listView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		listView = new ListView<String>();
		createListView();
	}

	private void createListView() {

		listOfRabbits = new HashMap<String, ModelRole>();

		ModelRole crazyRabbit = new Model("Crazy rabbit", "src/view/crazyRabbit2.png");
		ModelRole carrotWarrior = new Model("Carrot warrior", "src/view/carrotAttacks.png");
		ModelRole keyRabbit = new Model("Key rabbit", "src/view/youFoundTheKey.png");

		listOfRabbits.put("Crazy rabbit", crazyRabbit);
		listOfRabbits.put("Carrot warrior", carrotWarrior);
		listOfRabbits.put("Key rabbit", keyRabbit);

		ObservableList<String> items = FXCollections.observableArrayList("Crazy rabbit", "Carrot warrior",
				"Key rabbit");

		listView.setItems(items);

		listView.setOnMouseClicked(clickedRabbitAction);
		listView.setStyle("-fx-background-color: transparent;");

		setCellListView();

		VBox box = new VBox(listView);
		box.setAlignment(Pos.CENTER);

		box.setStyle("-fx-background-color: transparent;");

		Border_pane_rabbits.setTop(box);

	}

	private void setCellListView() {

		listView.setCellFactory(param -> new ListCell<String>() {

			private ImageView imageView = new ImageView();

			@Override
			public void updateItem(String name, boolean empty) {
				super.updateItem(name, empty);
				if (empty) {
					setStyle("-fx-background-color: transparent;");
					setText(null);
					setGraphic(null);
				} else {
					imageView.setImage(listOfRabbits.get(name).getImage());

					setStyle("-fx-background-color: transparent;");
					setText(name);
					setGraphic(imageView);
				}

			}

		});
	}

	EventHandler<MouseEvent> clickedRabbitAction = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {

			result = listOfRabbits.get(listView.getSelectionModel().getSelectedItem());
			if (result != null)
				closeStage();
		}
	};

	public ModelRole getResult() {
		return this.result;
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
