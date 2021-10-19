package view;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CatalogueInfo {
	
	private Model model;
	private String titleText;
	private String describeText;
	private Image image;
	
	
	public CatalogueInfo(String name, String path, String titleText, String describeText) {
		super();
		this.model = new Model(name, path);
		this.titleText = titleText;
		this.describeText = describeText;
		
		image = model.getImage();
	}


	public void setOnPageCurrentEnity(ImageView imageView, TextField titleTextField, TextArea describeTextField) {

		
		imageView.setImage(image);
		
		titleTextField.setText(titleText);
		
		describeTextField.setText(describeText);
	}
	
	
	
	
	
}
