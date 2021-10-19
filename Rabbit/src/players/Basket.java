package players;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Basket implements BasketRole, Serializable {
	private int basketValue;
	private int numberOfEggs;

	public int getNumberOfEggs() {
		return numberOfEggs;
	}

	public int getBasketValue() {
		return basketValue;
	}

	public Basket() {
		this.basketValue = 0;
		this.numberOfEggs = 0;
	}

	@Override
	public void put(int value) {

		basketValue += value;
		numberOfEggs++;
	}

	@Override
	public void doubleBasket() {
		basketValue = basketValue * 2;
		
	}

	@Override
	public void giveMeYourBasket(PlayerRole thisRabbit) {
		thisRabbit.addToBasket(basketValue);
		basketValue = 0;
		
	}
	

}
