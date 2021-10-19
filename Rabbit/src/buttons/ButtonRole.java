package buttons;

import java.io.Serializable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import view.ModelRole;

public interface ButtonRole extends Serializable{

	void addTo(GridPane gridPane);

	void disable(ModelRole model);

	void setOnAction(EventHandler<ActionEvent> buttonHandler);

	void setImageTo(ModelRole model);

	void addToButton(ModelRole model);

	void setBackground(String Path);


}
