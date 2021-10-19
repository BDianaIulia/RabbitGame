package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;

public class ExtraLifeState implements CollectibleStateRole,Serializable {
	CollectibleStateRole nextState;
	ExtraLifeRole extraLife;
	public ExtraLifeState(ExtraLifeRole extraLife, CollectibleStateRole blankState) {
		this.extraLife = extraLife;
		this.nextState = blankState;
	}

	@Override
	public CollectibleStateRole next() {
		
		return nextState;
	}

	@Override
	public void search(PlayerRole rabbit) {

		extraLife.giveLife(rabbit);
	}

	@Override
	public void loadImage(ButtonRole button) {
		extraLife.loadImage(button);
		
	}

}
