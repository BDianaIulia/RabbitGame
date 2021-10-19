package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;

public interface ExtraLifeRole extends Serializable{

	void giveLife(PlayerRole rabbit);

	void loadImage(ButtonRole button);

}
