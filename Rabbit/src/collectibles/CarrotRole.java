package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;

public interface CarrotRole extends Serializable {

	void changeRabbit(PlayerRole rabbit);

	void loadImage(ButtonRole button);

}
