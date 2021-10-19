package builders;

import java.io.Serializable;

import buttons.ButtonRole;
import collectibles.CollectibleRole;
import collectibles.CollectibleStateRole;
import collectibles.Trap;
import collectibles.TrapRole;
import collectibles.TrapState;
import field.InsideParcel;
import field.ParcelRole;

public class TrapBuilder implements CollectibleBuilderRole,Serializable {

	@Override
	public ParcelRole addCollectible(ButtonRole button,CollectibleStateRole blankState, CollectibleRole collectible) {
		TrapRole trap = new Trap(collectible.getModel());
		CollectibleStateRole trapState = new TrapState(trap, blankState);

		return new InsideParcel(trapState);

	}

}
