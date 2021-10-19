package builders;

import java.io.Serializable;

import buttons.ButtonRole;
import collectibles.BlankState;
import collectibles.CollectibleRole;
import collectibles.CollectibleStateRole;
import field.ParcelRole;

public interface CollectibleBuilderRole extends Serializable{

	ParcelRole addCollectible( ButtonRole button, CollectibleStateRole blankState, CollectibleRole collectible);

}
