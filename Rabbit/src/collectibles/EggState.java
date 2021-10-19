package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;

public class EggState implements CollectibleStateRole, Serializable {

	private CollectibleStateRole nextState;
	private EggRole egg;

	public EggState(CollectibleStateRole nextState, EggRole egg) {

		this.nextState = nextState;
		this.egg = egg;
	}

	@Override
	public CollectibleStateRole next() {

		return nextState;
	}

	@Override
	public void search(PlayerRole rabbit) {
		egg.addToBasket(rabbit);
		rabbit.nextPosition();

	}

	@Override
	public void loadImage(ButtonRole button) {
		egg.loadImage(button);

	}

}
