package field;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;
import view.ModelRole;

public interface ParcelRole extends Serializable {

	void search(PlayerRole rabbit);

	void loadImage(ButtonRole button);



}
