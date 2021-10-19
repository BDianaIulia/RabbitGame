package players;

import java.io.Serializable;

public class PlayerStatus implements PlayerStatusRole, Serializable {
	private int numberOfLives;
	private boolean rabbitIsCaught;

	public PlayerStatus() {
		super();
		numberOfLives = 1;
		rabbitIsCaught = false;
	}

	@Override
	public boolean isAlive() {
		if (numberOfLives > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void die() {
		numberOfLives--;

	}

	@Override
	public void getCaught() {
		rabbitIsCaught = true;

	}

	@Override
	public boolean isCaught() {
		// TODO Auto-generated method stub
		return rabbitIsCaught;
	}

	@Override
	public void escape() {
		rabbitIsCaught = false;

	}

	@Override
	public void addLife() {
		numberOfLives++;

	}

	@Override
	public void giveLife(PlayerRole warriorRabbit) {
		numberOfLives--;
		for (int i = 1; i <= numberOfLives; i++) {
			warriorRabbit.addLife();
		}

	}

}
