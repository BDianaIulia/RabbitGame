package builders;

import java.io.Serializable;

import buttons.ButtonRole;
import collectibles.CollectibleRole;
import collectibles.CollectibleStateRole;
import collectibles.ExtraLife;
import collectibles.ExtraLifeRole;
import collectibles.ExtraLifeState;
import collectibles.SpiderWeb;
import collectibles.SpiderWebRole;
import collectibles.SpiderWebState;
import field.InsideParcel;
import field.ParcelRole;

public class ExtraLifeBuilder implements CollectibleBuilderRole,Serializable {

	@Override
	public ParcelRole addCollectible(ButtonRole button, CollectibleStateRole blankState, CollectibleRole collectible) {
		ExtraLifeRole extraLife = new ExtraLife(collectible.getModel());
		CollectibleStateRole extraLifeState = new ExtraLifeState(extraLife, blankState);
		return new InsideParcel(extraLifeState);
		
	}

}
