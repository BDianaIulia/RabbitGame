package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import application.Game;
import application.Loader;
import builders.BackgroundBuilder;
import builders.GameBuilder;
import buttons.ButtonRole;
import buttons.InteractiveButton;
import collectibles.CollectibleRole;
import field.BestBasketRole;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.ModelRole;
import view.NextScene;

public class GamePageController implements Initializable {

	int gridLength;
	double buttonSize;
	ButtonRole[][] buttons;
	GameBuilder gameBuilder;
	Game game;

	@FXML
	private Button StartButton;

	public GamePageController(int gridLength, double buttonSize) {
		super();
		this.gridLength = gridLength;
		this.buttonSize = buttonSize;
	}

	public GamePageController(int gridLength, double buttonSize, Game game) {
		this.gridLength = gridLength;
		this.buttonSize = buttonSize;
		this.game = game;
	}

	@FXML
	private Button PauseButton;

	@FXML
	private BorderPane Border_pane_game;

	@FXML
	private GridPane grid_pane_game;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		PauseButton.setDisable(true);

		Platform.runLater(() -> {
			buttons = new ButtonRole[101][101];

			try {

				for (int i = 1; i <= gridLength; i++) {

					for (int j = 1; j <= gridLength; j++) {

						buttons[i][j] = new InteractiveButton(i, j, gridLength, buttonSize, "-fx-base: green;", "Click to add a collectible");
						buttons[i][j].addTo(grid_pane_game);
						buttons[i][j].setOnAction(insideButtonHandler);

					}
				}
				for (int i = 1; i <= gridLength; i++) {
					setOutsideButton(0, i);
					setOutsideButton(i, 0);
					setOutsideButton(gridLength + 1, i);
					setOutsideButton(i, gridLength + 1);

				}
				buildGame(buttons);

				Border_pane_game.setCenter(grid_pane_game);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

	}

	private void buildGame(ButtonRole[][] buttons) {

		if (game == null) {
			gameBuilder = new GameBuilder();
			game = gameBuilder.build(gridLength, buttons);
			return;
		}

		game.addModelsToGame(buttons, gridLength);
	}

	private void setOutsideButton(int i, int j) {
		buttons[i][j] = new InteractiveButton(i, j, gridLength, buttonSize, "-fx-base: white;","Click to add a player");
		buttons[i][j].setOnAction(outsideButtonHandler);
		buttons[i][j].addTo(grid_pane_game);
	}

	@FXML
	public void StartButtonPressed(ActionEvent event) {
		

		PauseButton.setDisable(false);

		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				StartButton.setDisable(true);
				startGame();

				return null;
			}
		};
		new Thread(task).start();

	}

	@FXML
	public void PauseButtonPressed(ActionEvent event) throws IOException, ClassNotFoundException {
		game.pauseGame();
		StartButton.setDisable(false);

		PopUpControllerRole popupPauseAndSaveController = new Pop_upPauseAndSaveController();
		showPopupWindow(popupPauseAndSaveController, "/fxml/PopupPauseAndSave.fxml", "src/view/background.png");

		boolean wasSaved = ((Pop_upPauseAndSaveController) popupPauseAndSaveController).getResult();

		if (wasSaved)
			saveGame();

		StartButton.fire();

	}

	private void saveGame() throws IOException {
		FileOutputStream fout = new FileOutputStream("saveGame.txt");
		ObjectOutputStream out = new ObjectOutputStream(fout);

		Loader loader = new Loader(gridLength, buttonSize, game);

		out.writeObject(loader);

		out.flush();
		out.close();
	}

	EventHandler<ActionEvent> outsideButtonHandler = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {

			Button chosenButton = (Button) event.getSource();

			PopUpControllerRole popupRabbitController = new Pop_upRabbitController();
			showPopupWindow(popupRabbitController, "/fxml/PopupRabbitWindow.fxml", "src/view/background.png");

			ModelRole chosenRabbitModel = ((Pop_upRabbitController) popupRabbitController).getResult();

			System.out.println(chosenButton.getId());
			int y = Integer.parseInt(chosenButton.getId()) % (gridLength + 2);
			int x = Integer.parseInt(chosenButton.getId()) / (gridLength + 2);
			buttons[x][y].addToButton(chosenRabbitModel);

			gameBuilder.addRabbit(x, y, chosenRabbitModel, buttons[x][y]);
		}
	};

	EventHandler<ActionEvent> insideButtonHandler = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {

			Button chosenButton = (Button) event.getSource();

			PopUpControllerRole popupEggController = new Pop_upEggController();
			showPopupWindow(popupEggController, "/fxml/PopupEggWindow.fxml", "src/view/background.png");

			CollectibleRole chosenCollectible = ((Pop_upEggController) popupEggController).getResult();
			chosenCollectible.setImageTo(chosenButton);

			int y = Integer.parseInt(chosenButton.getId()) % (gridLength + 2);
			int x = Integer.parseInt(chosenButton.getId()) / (gridLength + 2);

			gameBuilder.addEgg(x, y, chosenCollectible);
		}
	};

	public void showPopupWindow(PopUpControllerRole controller, String fxmlDocument, String pathBackground) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(fxmlDocument));
		loader.setController(controller);
		Parent layout;

		try {
			layout = loader.load();

			Stage popupStage = new Stage();

			controller.setStage(popupStage);

			popupStage.initStyle(StageStyle.TRANSPARENT);
			popupStage.initOwner(getPrimaryStage());
			popupStage.initModality(Modality.WINDOW_MODAL);

			BackgroundBuilder background = new BackgroundBuilder(pathBackground);

			NextScene nextScene = new NextScene();
			nextScene.showAndWaitNewStage(popupStage, layout, background, 400);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Stage getPrimaryStage() {
		return (Stage) Border_pane_game.getScene().getWindow();
	}

	public Scene getScene() {
		return Border_pane_game.getScene();
	}

	public void startGame() {

		game.play(this);

	}

	public void stopGame(BestBasketRole bestBasket, int numberOfTurns) {

		Platform.runLater(() -> {
			PopUpControllerRole popupFinalPageController = new FinalPageController(bestBasket, numberOfTurns);
			showPopupWindow(popupFinalPageController, "/fxml/FinalPage.fxml", "src/view/background.png");

			try {
				BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/fxml/FirstPage.fxml"));

				BackgroundBuilder background = new BackgroundBuilder("src/view/background.png");
				NextScene nextScene = new NextScene();
				nextScene.showNewStage(getPrimaryStage(), root, background, 400);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
