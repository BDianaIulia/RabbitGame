package field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import application.GameFieldRole;
import buttons.ButtonRole;
import controllers.GamePageController;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.util.Duration;
import players.PlayerRole;

public class Field implements GameFieldRole, ParcelFieldRole, Serializable {

	private List<PlayerRole> playersOnField;
	List<PlayerRole> clonePlayersOnField;
	private ButtonRole buttons[][];
	private ParcelRole parcel[][];
	private BestBasketRole bestBasket;
	private boolean gameIsPlaying;

	public void setParcel(ParcelRole[][] parcel) {
		this.parcel = parcel;
	}

	public Field(List<PlayerRole> playersOnField) {

		this.playersOnField = playersOnField;
		bestBasket = new BestBasket();
		gameIsPlaying = true;
	}

	public void playTurn() {

		// This was used in order to be able to delete inside for..each
		clonePlayersOnField = new ArrayList<>(playersOnField);

		playPlayersTurn();

	}

	private void playPlayersTurn() {
		for (PlayerRole player : clonePlayersOnField) {

			if (player.isAlive() && !(player.isCaught())) {
				wait(500);
			}

			if (player.isCaught() && clonePlayersOnField.size() == 1) {
				wait(500);
			}
			if (!gameIsPlaying) {
				rearrangePlayerList(player);

				break;
			}
			player.playTurn();

		}
	}

	private void rearrangePlayerList(PlayerRole player) {
		int index = playersOnField.indexOf(player);
		List<PlayerRole> newPlayersOnField = new ArrayList<PlayerRole>();

		newPlayersOnField.addAll(playersOnField.subList(index, playersOnField.size()));
		newPlayersOnField.addAll(playersOnField.subList(0, index));

		playersOnField = newPlayersOnField;

	}

	private void wait(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean playersAreOnField() {

		if (playersOnField.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public void search(PlayerRole rabbit, int x, int y) {
		if (rabbit.isAlive()) {
			rabbit.changeButton(buttons[x][y]);

			parcel[x][y].search(rabbit);
			rabbit.playersSearch(playersOnField);
		} else {
			removePlayer(rabbit);
		}

	}

	@Override
	public void removePlayer(PlayerRole rabbit) {

		playersOnField.remove(rabbit);

	}

	@Override
	public int getMaxY() {

		return parcel[0].length - 1;
	}

	@Override
	public int getMaxX() {

		return parcel.length - 1;
	}

	@Override
	public void checkBestScore(PlayerRole rabbit) {
		rabbit.checkScore(bestBasket);
	}

	public void setButtons(ButtonRole[][] buttons) {
		// TODO Auto-generated method stub
		this.buttons = buttons;
	}

	@Override
	public void addModelsToGame(ButtonRole[][] buttons, int gridLength) {
		this.buttons = buttons;
		addModelsToParcels(gridLength);
		addModelsToPlayers();
		bestBasket.loadImage();

	}

	private void addModelsToParcels(int gridLength) {
		for (int i = 1; i <= gridLength; i++) {
			for (int j = 1; j <= gridLength; j++) {
				parcel[i][j].loadImage(buttons[i][j]);
			}
		}

	}

	private void addModelsToPlayers() {
		for (PlayerRole player : playersOnField) {
			player.loadImage(buttons);
		}
	}

	@Override
	public void printScore(GamePageController gamePageController, int numberOfTurns) {
		gamePageController.stopGame(bestBasket, numberOfTurns);
	}

	@Override
	public void resumeGame() {
		gameIsPlaying = true;

	}

	@Override
	public void pauseGame() {
		gameIsPlaying = false;

	}

	@Override
	public boolean gameIsPlaying() {
		return gameIsPlaying;
	}

}
