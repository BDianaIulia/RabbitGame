package collectibles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

import buttons.ButtonRole;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import players.PlayerRole;
import view.Model;
import view.ModelRole;

public class Egg implements EggRole, CollectibleRole,Serializable{
	
	int value = 0;
	ModelRole model;
	

	public Egg(String name, String path) {
		super();
		model = new Model(name, path);
		
	}
	
	public Egg(ModelRole model, int value) {
		this.model = model;
		this.value = value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}
	
	
	public int getValue() {
		
		return value;
	}
	
	
	@Override
	public void addToBasket(PlayerRole rabbit) {

		rabbit.addToBasket(value);		
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
	public void loadImage(ButtonRole button) {
		model.getImage();
		button.setImageTo(model);
		
	}
}
