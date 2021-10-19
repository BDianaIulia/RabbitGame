package application;

import java.io.Serializable;

import buttons.ButtonRole;
import controllers.GamePageController;
import players.PlayerRole;

public interface GameFieldRole extends Serializable {

	boolean playersAreOnField();

	void playTurn();

	void removePlayer(PlayerRole rabbit);

	void checkBestScore(PlayerRole rabbit);

	void addModelsToGame(ButtonRole[][] buttons, int gridLength);

	void printScore(GamePageController gamePageController, int numberOfTurns);

	void resumeGame();

	void pauseGame();

	boolean gameIsPlaying();

}
