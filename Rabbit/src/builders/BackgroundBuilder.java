package builders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class BackgroundBuilder implements Serializable{
	
	private String path;
	
	public BackgroundBuilder(String path) {
		super();
		this.path = path;
	}

	public void setBackground(Pane root) throws FileNotFoundException
	{
		Image img = new Image(new FileInputStream(path));
		
		BackgroundImage backgroundImg = new BackgroundImage(img, 
		    BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
		    BackgroundPosition.DEFAULT, 
		    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
		
		Background background = new Background(backgroundImg);
		root.setBackground(background);
	}
	
}
