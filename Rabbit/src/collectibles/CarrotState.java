package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;
import players.Rabbit;

public class CarrotState implements CollectibleStateRole,Serializable {
	CollectibleStateRole blankState;
	CarrotRole carrot;

	public CarrotState(CarrotRole carrot, CollectibleStateRole blankState) {
		this.blankState = blankState;
		this.carrot = carrot;
	}

	@Override
	public CollectibleStateRole next() {
		// TODO Auto-generated method stub
		return blankState;
	}

	@Override
	public void search(PlayerRole rabbit) {
		if (rabbit.isNormalRabbit()) {
			
			carrot.changeRabbit(rabbit);
		}
	}

	@Override
	public void loadImage(ButtonRole button) {
		carrot.loadImage(button);
		
	}

}
