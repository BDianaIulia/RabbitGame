package builders;

import java.io.Serializable;

import buttons.ButtonRole;
import collectibles.Carrot;
import collectibles.CarrotRole;
import collectibles.CarrotState;
import collectibles.CollectibleRole;
import collectibles.CollectibleStateRole;
import collectibles.ExtraLife;
import collectibles.ExtraLifeRole;
import collectibles.ExtraLifeState;
import field.InsideParcel;
import field.ParcelRole;
import view.Model;
import view.ModelRole;

public class CarrotBuilder implements CollectibleBuilderRole,Serializable {

	@Override
	public ParcelRole addCollectible(ButtonRole button, CollectibleStateRole blankState, CollectibleRole collectible) {
		ModelRole warriorRabbitModel = new Model("Carrot warrior", "src/view/carrotAttacks.png");
		warriorRabbitModel.getImage();
		
		CarrotRole carrot = new Carrot(collectible.getModel(),warriorRabbitModel);
		CollectibleStateRole carrotState = new CarrotState(carrot, blankState);
		
		return new InsideParcel(carrotState);
	}

}
