package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;

public interface SpiderWebRole extends Serializable{

	void hold(PlayerRole rabbit);

	void loadImage(ButtonRole button);

}
