package view;

import java.io.Serializable;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

public interface ModelRole extends Serializable{

	void setImageTo(Button choseButton);

	Image getImage();

	String getName();

	

}
