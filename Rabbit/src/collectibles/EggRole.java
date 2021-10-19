package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import players.PlayerRole;

public interface EggRole extends Serializable{


	void setValue(int userEggValue);

	int getValue();

	void addToBasket(PlayerRole rabbit);

	void loadImage(ButtonRole button);

	

}
