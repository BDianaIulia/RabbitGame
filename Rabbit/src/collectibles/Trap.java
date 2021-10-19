package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import players.PlayerRole;
import view.Model;
import view.ModelRole;

public class Trap implements TrapRole, CollectibleRole, Serializable {
	private ModelRole model;

	public Trap(String name, String path) {
		super();
		this.model = new Model(name, path);
	}

	public Trap(ModelRole model) {
		this.model = model;
	}

	@Override
	public void kill(PlayerRole rabbit) {
		rabbit.die();

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
		// TODO Auto-generated method stub
		return model;
	}

	@Override
	public void loadImage(ButtonRole button) {
		model.getImage();
		button.setImageTo(model);

	}

}
