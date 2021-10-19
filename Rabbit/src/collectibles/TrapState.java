package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;

public class TrapState implements CollectibleStateRole,Serializable {
	private CollectibleStateRole nextState;
	private TrapRole trap;
	public TrapState(TrapRole trap, CollectibleStateRole nextState) {
		super();
		this.trap = trap;
		this.nextState = nextState;
		
	}

	@Override
	public CollectibleStateRole next() {
		return nextState;
	}

	@Override
	public void search(PlayerRole rabbit) {
		trap.kill(rabbit);
		

	}

	@Override
	public void loadImage(ButtonRole button) {
		trap.loadImage(button);
		
	}

}
