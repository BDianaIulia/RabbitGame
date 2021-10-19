package application;

import java.io.IOException;
import java.io.Serializable;

import builders.BackgroundBuilder;
import controllers.GamePageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import view.NextScene;

public class Loader implements Serializable{
	
	private int gridLength;
	private int windowPrefLength = 400;
	private double buttonSize = 40;
	private transient Stage stage;
	public Game game;

	public Loader(int gridLength, double buttonSize, Game game) {
		super();
		this.gridLength = gridLength;
		this.buttonSize = buttonSize;
		this.game = game;
		//this.stage = stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void loadGame()
	{
		

		try {

			setSizeWindow(gridLength);
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/GamePage.fxml"));
			loader.setController(new GamePageController(gridLength, buttonSize,game));
			Parent layout = loader.load();
			BackgroundBuilder background = new BackgroundBuilder("src/view/background.png");
			
			NextScene nextScene = new NextScene();
			nextScene.showNewStage(stage, layout, background, windowPrefLength);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setSizeWindow(int gridLength )
	{
		int difference = gridLength - 5;
		
		windowPrefLength += difference * 40;
		stage.setX(stage.getX() - 10 * difference);
		stage.setY(stage.getY() - 10 * difference);
	}

}
