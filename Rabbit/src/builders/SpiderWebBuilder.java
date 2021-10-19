package builders;

import java.io.Serializable;

import buttons.ButtonRole;
import collectibles.CollectibleRole;
import collectibles.CollectibleStateRole;
import collectibles.SpiderWeb;
import collectibles.SpiderWebRole;
import collectibles.SpiderWebState;
import collectibles.Trap;
import collectibles.TrapRole;
import collectibles.TrapState;
import field.InsideParcel;
import field.ParcelRole;

public class SpiderWebBuilder implements CollectibleBuilderRole,Serializable {

	@Override
	public ParcelRole addCollectible(ButtonRole button, CollectibleStateRole blankState, CollectibleRole collectible) {
		SpiderWebRole spiderWeb = new SpiderWeb(collectible.getModel());
		CollectibleStateRole spiderWebState = new SpiderWebState(spiderWeb, blankState);
		button.setBackground("-fx-base: green;"+"-fx-background-image: url('/view/Web.png');" + "-fx-background-size: ");
		return new InsideParcel(spiderWebState);
		
	}

}
