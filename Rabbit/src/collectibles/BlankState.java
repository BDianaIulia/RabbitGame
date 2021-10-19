package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;

public class BlankState implements CollectibleStateRole,Serializable {

	private CollectibleStateRole nextState;
	
	public void setNextState(CollectibleStateRole nextState) {
		this.nextState = nextState;
	}

	@Override
	public CollectibleStateRole next() {
		
		return nextState;
	}

	@Override
	public void search(PlayerRole rabbit) {


	}

	@Override
	public void loadImage(ButtonRole button) {
		
		
	}

}
