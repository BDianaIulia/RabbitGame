package application;

import java.io.Serializable;

import buttons.ButtonRole;
import controllers.GamePageController;

public class Game implements Serializable {

	public int numberOfTurns = 0;
	private GameFieldRole field;

	public Game(GameFieldRole field) {

		this.field = field;
	}

	public void play(GamePageController gamePageController) {
		field.resumeGame();
		while (field.playersAreOnField() && field.gameIsPlaying()) {
			numberOfTurns++;

			field.playTurn();

		}

		numberOfTurns--;

		if (!field.playersAreOnField())
			field.printScore(gamePageController, numberOfTurns);
	}

	public void pauseGame() {
		field.pauseGame();
	}

	public void addModelsToGame(ButtonRole[][] buttons, int gridLength) {
		field.addModelsToGame(buttons, gridLength);
	}

}
