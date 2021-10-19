package field;

import java.io.Serializable;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import players.BasketRole;
import view.ModelRole;

public interface BestBasketRole extends Serializable {

	void checkScore(BasketRole basket, ModelRole model);

	void winnerDetails(ImageView winnerImageView, TextField bestScore, TextField totalEggs);

	void loadImage();

}
