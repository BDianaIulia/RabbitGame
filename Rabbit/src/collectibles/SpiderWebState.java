package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;

public class SpiderWebState implements CollectibleStateRole,Serializable {
	CollectibleStateRole nextState;
	SpiderWebRole spiderWeb;
	public SpiderWebState(SpiderWebRole spiderWeb, CollectibleStateRole blankState) {
		this.nextState = blankState;
		this.spiderWeb = spiderWeb;
	}

	@Override
	public CollectibleStateRole next() {
		return this;
	}

	@Override
	public void search(PlayerRole rabbit) {
		spiderWeb.hold(rabbit);

	}

	@Override
	public void loadImage(ButtonRole button) {
		spiderWeb.loadImage(button);
		
	}
	

}
