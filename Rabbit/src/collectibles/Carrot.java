package collectibles;

import java.io.Serializable;

import buttons.ButtonRole;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import players.PlayerRole;
import players.PowerRole;
import players.WarriorRabbitPower;
import view.Model;
import view.ModelRole;

public class Carrot implements CarrotRole, CollectibleRole, Serializable {
	ModelRole warriorRabbitModel;
	ModelRole model;

	public Carrot(ModelRole model, ModelRole warriorRabbitModel) {
		this.model = model;
		this.warriorRabbitModel = warriorRabbitModel;
	}

	public Carrot(String name, String path) {
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
		// TODO Auto-generated method stub
		return model;
	}

	@Override
	public void changeRabbit(PlayerRole rabbit) {

		PowerRole warriorPower = new WarriorRabbitPower();

		rabbit.changeModel(warriorRabbitModel);
		rabbit.changePower(warriorPower);

	}

	@Override
	public void loadImage(ButtonRole button) {
		model.getImage();
		warriorRabbitModel.getImage();
		button.setImageTo(model);

	}

}
