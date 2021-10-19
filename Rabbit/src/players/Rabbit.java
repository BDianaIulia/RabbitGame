package players;

import java.io.Serializable;
import java.util.List;

import buttons.ButtonRole;
import field.BestBasketRole;
import position.PositionRoleState;
import view.ModelRole;

public class Rabbit implements PlayerRole, Serializable {

	private PowerRole rabbitPower;
	private PlayerSkeletonRole player;

	public Rabbit(PositionRoleState positionState, ModelRole model, ButtonRole button, PowerRole rabbitPower) {
		player = new Player(positionState, new Basket(), model, button, new PlayerStatus());
		this.rabbitPower = rabbitPower;
	}

	public void playersSearch(List<PlayerRole> playersOnField) {
		for (PlayerRole otherRabbit : playersOnField) {
			if (otherRabbit.isOnSamePlace(player.getButton()) && otherRabbit != this) {
				execute(otherRabbit);

			}
		}

	}

	public void execute(PlayerRole otherRabbit) {
		rabbitPower.execute(otherRabbit, this);

	}

	public void playTurn() {

		player.playTurn(this);

	}

	public void escape() {
		player.escape();

	}

	@Override
	public void addToBasket(int value) {

		player.addToBasket(value);

	}

	@Override
	public void checkScore(BestBasketRole bestBasket) {
		player.checkScore(bestBasket);

	}

	@Override
	public void changeButton(ButtonRole currentButton) {

		player.changeButton(currentButton);

	}

	public void die() {
		player.die();

	}

	public boolean isCaught() {
		return player.isCaught();

	}

	public boolean isAlive() {
		return player.isAlive();

	}

	@Override
	public boolean isOnSamePlace(ButtonRole button) {

		return player.isOnSamePlace(button);
	}

	@Override
	public int getBasket() {

		return player.getBasket();
	}

	@Override
	public void getCaught() {
		player.getCaught();

	}

	@Override
	public void addLife() {
		player.addLife();

	}

	@Override
	public void getBackInGame() {
		player.getBackInGame();

	}

	public ButtonRole getButton() {
		// TODO Auto-generated method stub
		return player.getButton();
	}

	public PositionRoleState getPositionState() {
		// TODO Auto-generated method stub
		return player.getPositionState();
	}

	@Override
	public void changeModel(ModelRole model) {
		player.changeModel(model);

	}

	@Override
	public void loadImage(ButtonRole[][] buttons) {
		player.loadImage(buttons, this);

	}

	@Override
	public void doubleBasket() {
		player.doubleBasket();

	}

	@Override
	public void giveMeYourBasket(PlayerRole thisRabbit) {
		player.giveMeYourBasket(thisRabbit);

	}

	@Override
	public void nextPosition() {
		player.nextPosition();

	}

	@Override
	public boolean isNormalRabbit() {
		return rabbitPower.isNormalRabbit();
	}

	@Override
	public void changePower(PowerRole warriorPower) {
		rabbitPower = warriorPower;

	}

	@Override
	public boolean isWarriorRabbit() {
		// TODO Auto-generated method stub
		return rabbitPower.isWarriorRabbit();
	}

	@Override
	public boolean isKeyRabbit() {
		// TODO Auto-generated method stub
		return rabbitPower.isKeyRabbit();
	}

}
