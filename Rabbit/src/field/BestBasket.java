package field;

import java.io.Serializable;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import players.BasketRole;
import view.Model;
import view.ModelRole;

public class BestBasket implements BestBasketRole, Serializable {
	private int numberOfEggs;
	private int bestBasketValue;
	private ModelRole winnerModel;

	@Override
	public void checkScore(BasketRole basket, ModelRole model) {
		int rabbitBasketValue = basket.getBasketValue();
		if (bestBasketValue <= rabbitBasketValue) {
			bestBasketValue = rabbitBasketValue;
			winnerModel = model;
		}
		numberOfEggs += basket.getNumberOfEggs();

	}

	@Override
	public void winnerDetails(ImageView winnerImageView, TextField bestScore, TextField totalEggs) {
		winnerImageView.setImage(winnerModel.getImage());
		bestScore.setText(Integer.toString(bestBasketValue));

		totalEggs.setText("From " + Integer.toString(numberOfEggs) + " total eggs collected");
	}

	@Override
	public void loadImage() {
		if (winnerModel != null)
			winnerModel.getImage();

	}

}
