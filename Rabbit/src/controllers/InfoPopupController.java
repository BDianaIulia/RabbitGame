package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.CatalogueInfo;
import view.Model;

public class InfoPopupController implements Initializable{

	@FXML
	private Button rightButton;
	
	@FXML
	private Button leftButton;
	
	@FXML
	private ImageView imageView;
	
	@FXML
	private TextField titleText;
	
	@FXML
	private TextArea describeText;
	
	private CatalogueInfo catalogueInfo[];
	private int stackTop = -1;
	
	private int presentPageNumber = 0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		catalogueInfo = new CatalogueInfo[20];
		
		Model modelArrow = new Model("arrow", "src/view/arrow.png");
		modelArrow.getImage();
		modelArrow.setImageTo(rightButton);
		
		
		Model modelArrow180 = new Model("arrow180", "src/view/arrow180.png");
		modelArrow180.getImage();
		modelArrow180.setImageTo(leftButton);
		
		
		
		addNewEntity("Crazy Rabbit", "src/view/crazyRabbit2.png", "Rabbit",
							"Rabbit is the base player of our game. His abilities involves : walking, interacting with items "
							+ "(eg. Egg, Trap) and developing actions throughout the game. Finally, when he is no longer on the play board, he dies.");
		
		addNewEntity("Key Rabbit", "src/view/youFoundTheKey.png", "Key Rabbit",
				"Key rabbit inheritence almost all rabbit's abilities and skills."
				+ " Besides that, he has a power affecting all rabbits. When a key rabbit meets a rabbit, it doubles its basket value.");
		
		addNewEntity("Warrior Rabbit", "src/view/carrotAttacks.png", "Warrior Rabbit",
				"Warrior rabbit is the last evolution of a rabbit. His power is to"
				+ " instantly kill a rabbit and steal its basket. Also key rabbit should be afraid of him, because warrior rabbit would block his powers.");
		
		addNewEntity("Egg", "src/view/CrazyEgg.png", "Egg",
				"Egg is a collectible item that can be added to the game alongside "
				+ "a value. Once it is collected, its value is added to the player's basket and also changing his direction "
				+ "anti-clockwise(eg. Direction to west becomes direction to south).");
		
		addNewEntity("Trap", "src/view/trap.png", "Trap",
				"Trap is among the simpliest of them all. Once a rabbit steps on one of it, he dies.");
		
		addNewEntity("Spider Web", "src/view/Web.png", "Spider web",
				"Spider web does exactly what a spider web does in most of the game: catch the prey "
				+ "and retain from moving. In our case: the rabbits. So, all players who step on a spider web, stay caught for 1 turn.");
		
		addNewEntity("Extra life", "src/view/ExtraLife.png", "Extra life",
				"Extra life is an item that when collected, it provide its carrier an extra life."
				+ " For example, if you pick an extra life, you do not die from a trap and only one.");
		
		addNewEntity("Carrot", "src/view/Carrot.png", "Carrot",
				"Carrot is a weapon designed for rabbits. It is in fact the weapon warrior "
				+ "rabbit is carrying. So, when a rabbit collects a carrot, it becomes an warrior rabbit.");
		
		
		setOnPageCurrentEnity();
	}
	
	private void addNewEntity(String name, String path, String title, String describe)
	{
		stackTop++;
		catalogueInfo[stackTop] = new CatalogueInfo(name, path, title, describe);
	}
	
	private void setOnPageCurrentEnity()
	{
		catalogueInfo[presentPageNumber].setOnPageCurrentEnity(imageView, titleText, describeText);
	}
	

	
	@FXML
	private void rightButtonPressed(ActionEvent event)
	{
		presentPageNumber++;
		
		if( presentPageNumber > stackTop)
			presentPageNumber = 0;
		
		setOnPageCurrentEnity();
	}
	
	@FXML
	private void leftButtonPressed(ActionEvent event)
	{
		presentPageNumber--;
		
		if( presentPageNumber < 0 )
			presentPageNumber = stackTop;
		
		setOnPageCurrentEnity();
	}
}
