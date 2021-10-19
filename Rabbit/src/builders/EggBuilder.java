package builders;

import java.io.IOException;
import java.io.Serializable;

import buttons.ButtonRole;
import collectibles.CollectibleRole;
import collectibles.CollectibleStateRole;
import collectibles.Egg;
import collectibles.EggRole;
import collectibles.EggState;
import controllers.ValueForEggController;
import field.InsideParcel;
import field.ParcelRole;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import view.ModelRole;
import view.NextScene;

public class EggBuilder implements CollectibleBuilderRole,Serializable {

	int value;

	@Override
	public ParcelRole addCollectible(ButtonRole button, CollectibleStateRole blankState, CollectibleRole collectible) {

		value = insertValueFromGUI();
		ModelRole eggModel = collectible.getModel();

		EggRole egg = new Egg(collectible.getModel(), value);
		CollectibleStateRole eggState = new EggState(blankState, egg);

		if (value != -1) {
			return new InsideParcel(eggState);
		} else {
			button.disable(eggModel);
			return new InsideParcel(blankState);
		}

	}

	private int insertValueFromGUI() {

		return showPopupWindow();

	}

	public int showPopupWindow() {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/EggValue.fxml"));

		ValueForEggController controller = new ValueForEggController();
		loader.setController(controller);
		Parent layout;

		try {
			layout = loader.load();

			Stage popupStage = new Stage();

			controller.setStage(popupStage);

			BackgroundBuilder background = new BackgroundBuilder("src/view/background.png");

			NextScene nextScene = new NextScene();
			nextScene.showAndWaitNewStage(popupStage, layout, background, 300);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return controller.getResult();
	}

	/*
	 * private Stage getPrimaryStage() { return (Stage)
	 * Border_pane_game.getScene().getWindow(); }
	 */

}
