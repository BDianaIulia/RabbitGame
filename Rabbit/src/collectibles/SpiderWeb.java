package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import players.PlayerRole;
import view.Model;
import view.ModelRole;

public class SpiderWeb implements SpiderWebRole, CollectibleRole,Serializable {
	private ModelRole model;

	public SpiderWeb(ModelRole model) {
		this.model = model;
	}

	public SpiderWeb(String name, String path) {
		this.model = new Model(name, path);
	}

	@Override
	public void setImageTo(Button button) {
		model.setImageTo(button);

	}

	@Override
	public Image getImage() {
		return model.getImage();
	}

	@Override
	public String getModelName() {
		return model.getName();
	}

	@Override
	public ModelRole getModel() {
		return model;
	}

	@Override
	public void hold(PlayerRole rabbit) {
		rabbit.getCaught();
		
	}
	@Override
	public void loadImage(ButtonRole button) {
		model.getImage();
		button.setImageTo(model);
		
	}

}
