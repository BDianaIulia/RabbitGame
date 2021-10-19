package players;

import java.io.Serializable;
import java.util.List;

import buttons.ButtonRole;
import field.BestBasketRole;
import position.PositionRoleState;
import view.ModelRole;

public interface PlayerRole extends Serializable{

	void playTurn();

	void addToBasket(int value);

	void checkScore(BestBasketRole bestBasket);

	void changeButton(ButtonRole currentButton);

	void playersSearch(List<PlayerRole> playersOnField);

	boolean isOnSamePlace(ButtonRole button);

	void execute(PlayerRole otherRabbit);

	int getBasket();

	boolean isCaught();

	void die();
	
	void escape();

	void getCaught();

	boolean isAlive();

	void addLife();

	void getBackInGame();

	ButtonRole getButton();

	PositionRoleState getPositionState();

	void changeModel(ModelRole model);

	void loadImage(ButtonRole[][] buttons);


	void doubleBasket();

	void giveMeYourBasket(PlayerRole thisRabbit);

	void nextPosition();

	boolean isNormalRabbit();

	void changePower(PowerRole warriorPower);

	boolean isWarriorRabbit();

	boolean isKeyRabbit();

}
