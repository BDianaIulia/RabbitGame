package position;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;
import players.Rabbit;
import view.ModelRole;

public interface PositionRoleState extends Serializable{

	void move();

	void search(PlayerRole rabbit);

	PositionRoleState next();

	boolean isInitialState();

	void loadImage(ButtonRole[][] buttons, ModelRole model, PlayerRole rabbit);


}
