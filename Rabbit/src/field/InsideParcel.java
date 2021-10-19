package field;

import java.io.Serializable;

import buttons.ButtonRole;
import collectibles.CollectibleStateRole;
import players.PlayerRole;
import view.ModelRole;

public class InsideParcel implements ParcelRole,Serializable {

	CollectibleStateRole currentState;

	public InsideParcel(CollectibleStateRole currentState) {

		this.currentState = currentState;
	}

	@Override
	public void search(PlayerRole rabbit) {

		currentState.search(rabbit);
		currentState = currentState.next();

	}

	@Override
	public void loadImage(ButtonRole button) {
		currentState.loadImage(button);
		
	}

}
