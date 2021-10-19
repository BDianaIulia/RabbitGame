package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Model implements ModelRole, Serializable {
	private String name;
	private String path;
	private transient Image image;

	public Model(String name, String path) {
		super();
		this.name = name;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public Image getImage() {

		image = null;

		try {
			image = new Image(new FileInputStream(path), 100, 100, false, false);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return image;
	}

	public void setImageTo(Button button) {

		ImageView imageView = new ImageView(image);
		imageView.fitWidthProperty().bind(button.widthProperty());
		imageView.fitHeightProperty().bind(button.heightProperty());
		Platform.runLater(() -> button.setGraphic(imageView) );
	}
}
