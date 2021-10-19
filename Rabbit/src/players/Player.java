package players;

import buttons.ButtonRole;
import field.BestBasketRole;
import position.PositionRoleState;
import view.ModelRole;

public class Player implements PlayerSkeletonRole {
	private PositionRoleState positionState;
	private BasketRole basket;
	private ModelRole model;
	private ButtonRole button;
	private PlayerStatusRole playerStatus;
	

	public Player(PositionRoleState positionState, BasketRole basket, ModelRole model, ButtonRole button,
			PlayerStatusRole playerStatus) {
		super();
		this.positionState = positionState;
		this.basket = basket;
		this.model = model;
		this.button = button;
		this.playerStatus = playerStatus;
	}

	@Override
	public void playTurn(PlayerRole rabbit) {
		if (isCaught()) {
			playerStatus.escape();
			return;
		}

		button.disable(model);
		if (isAlive()) {
			positionState.move();
		}

		positionState.search(rabbit);

	}

	@Override
	public void addToBasket(int value) {

		basket.put(value);

	}

	@Override
	public void checkScore(BestBasketRole bestBasket) {
		bestBasket.checkScore(basket, model);

	}

	@Override
	public void changeButton(ButtonRole currentButton) {

		currentButton.addToButton(model);
		this.button = currentButton;

	}

	@Override
	public boolean isOnSamePlace(ButtonRole button) {
		// TODO Auto-generated method stub
		return (this.button == button);
	}

	public int getBasket() {
		// TODO Auto-generated method stub
		return basket.getBasketValue();
	}

	public boolean isCaught() {
		return playerStatus.isCaught();

	}

	public boolean isAlive() {
		return playerStatus.isAlive();

	}

	public void die() {
		playerStatus.die();
		if (!isAlive())
			button.disable(model);

	}

	@Override
	public void escape() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getCaught() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addLife() {
		playerStatus.addLife();

	}

	@Override
	public void getBackInGame() {
		positionState = positionState.next().next();

	}

	public ButtonRole getButton() {
		// TODO Auto-generated method stub
		return button;
	}

	public PositionRoleState getPositionState() {
		// TODO Auto-generated method stub
		return positionState;
	}

	@Override
	public void changeModel(ModelRole model) {
		button.disable(this.model);
		this.model = model;
		button.addToButton(model);

	}

	@Override
	public void loadImage(ButtonRole[][] buttons, PlayerRole rabbit) {
		model.getImage();
		positionState.loadImage(buttons, model, rabbit);

	}


	@Override
	public void doubleBasket() {
		basket.doubleBasket();

	}

	@Override
	public void giveMeYourBasket(PlayerRole thisRabbit) {
		basket.giveMeYourBasket(thisRabbit);

	}

	@Override
	public void nextPosition() {
		positionState = positionState.next();

	}

}
