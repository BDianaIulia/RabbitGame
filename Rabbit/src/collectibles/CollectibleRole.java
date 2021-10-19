package collectibles;

import java.io.Serializable;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import view.ModelRole;

public interface CollectibleRole extends Serializable {
	void setImageTo(Button button);

	Image getImage();

	String getModelName();

	ModelRole getModel();
}
