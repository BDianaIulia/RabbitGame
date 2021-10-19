package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import players.PlayerRole;

public interface TrapRole extends Serializable{

	void kill(PlayerRole rabbit);

	void loadImage(ButtonRole button);

	

}
