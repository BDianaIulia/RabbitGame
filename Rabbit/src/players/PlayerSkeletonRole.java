package players;

import java.util.List;

import buttons.ButtonRole;
import field.BestBasketRole;
import position.PositionRoleState;
import view.ModelRole;

public interface PlayerSkeletonRole {

	void playTurn(PlayerRole rabbit);

	void addToBasket(int value);

	void checkScore(BestBasketRole bestBasket);

	void changeButton(ButtonRole currentButton);

	boolean isOnSamePlace(ButtonRole button);

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

	void loadImage(ButtonRole[][] buttons,PlayerRole rabbit);

	void doubleBasket();

	void giveMeYourBasket(PlayerRole thisRabbit);

	void nextPosition();


}
