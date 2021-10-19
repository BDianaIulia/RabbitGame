package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;

public interface CollectibleStateRole extends Serializable{

	CollectibleStateRole next();

	void search(PlayerRole rabbit);

	void loadImage(ButtonRole button);

}
