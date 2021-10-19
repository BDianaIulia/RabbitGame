package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import players.PlayerRole;
import view.Model;
import view.ModelRole;

public class ExtraLife implements CollectibleRole, ExtraLifeRole,Serializable {
	ModelRole model;

	public ExtraLife(String name, String path) {
		super();
		this.model = new Model(name, path);
	}

	public ExtraLife(ModelRole model) {
		this.model = model;
	}

	@Override
	public void setImageTo(Button choseButton) {
		model.setImageTo(choseButton);

	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
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
	public void giveLife(PlayerRole rabbit) {
		rabbit.addLife();
		
	}
	@Override
	public void loadImage(ButtonRole button) {
		model.getImage();
		button.setImageTo(model);
		
	}

}
