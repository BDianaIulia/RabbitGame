package controllers;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import collectibles.Carrot;
import collectibles.CollectibleRole;
import collectibles.Egg;
import collectibles.ExtraLife;
import collectibles.SpiderWeb;
import collectibles.Trap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Pop_upEggController implements Initializable, PopUpControllerRole {

	private Stage stage = null;
	private CollectibleRole result;

	@FXML
	private BorderPane Border_pane_eggs;
	@FXML
	private AnchorPane Anchor_pane_value_egg;

	Map<String, CollectibleRole> listOfCollectibles;
	ListView<String> listView;
	VBox box;
	TextField textField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		listView = new ListView<String>();
		createListView();

	}

	private void createListView() {

		listOfCollectibles = new HashMap<String, CollectibleRole>();

		CollectibleRole Egg = new Egg("Egg", "src/view/CrazyEgg.png");
		CollectibleRole Trap = new Trap("Trap", "src/view/trap.png");
		CollectibleRole SpiderWeb = new SpiderWeb("Spider Web", "src/view/Web.png");
		CollectibleRole ExtraLife = new ExtraLife("Extra Life", "src/view/ExtraLife.png");
		CollectibleRole Carrot = new Carrot("Carrot", "src/view/Carrot.png");

		listOfCollectibles.put("Egg", Egg);
		listOfCollectibles.put("Trap", Trap);
		listOfCollectibles.put("SpiderWeb", SpiderWeb);
		listOfCollectibles.put("Extra Life", ExtraLife);
		listOfCollectibles.put("Carrot", Carrot);

		ObservableList<String> items = FXCollections.observableArrayList("Egg", "Trap", "SpiderWeb", "Extra Life",
				"Carrot");

		listView.setItems(items);

		listView.setOnMouseClicked(clickedEggAction);
		listView.setStyle("-fx-background-color: transparent;");

		setCellListView();

		box = new VBox(listView);
		box.setAlignment(Pos.CENTER);

		box.setStyle("-fx-background-color: transparent;");

		Border_pane_eggs.setTop(box);

	}

	private void setCellListView() {

		listView.setCellFactory(param -> new ListCell<String>() {

			private ImageView imageView = new ImageView();

			@Override
			public void updateItem(String name, boolean empty) {
				super.updateItem(name, empty);
				if (empty || name == null) {
					setStyle("-fx-background-color: transparent;");
					setText(null);
					setGraphic(null);
				} else {
					imageView.setImage(listOfCollectibles.get(name).getImage());

					setStyle("-fx-background-color: transparent;");
					setText(name);
					setGraphic(imageView);
				}
			}

		});
	}

	EventHandler<MouseEvent> clickedEggAction = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {

			result = listOfCollectibles.get(listView.getSelectionModel().getSelectedItem());

			if (result != null)
				closeStage();
		}
	};

	public CollectibleRole getResult() {
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
