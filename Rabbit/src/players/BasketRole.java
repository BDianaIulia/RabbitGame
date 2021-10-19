package players;

import java.io.Serializable;

public interface BasketRole extends Serializable{

	int getNumberOfEggs();

	int getBasketValue();

	void put(int value);

	void doubleBasket();

	void giveMeYourBasket(PlayerRole thisRabbit);
}
