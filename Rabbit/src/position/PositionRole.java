package position;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;
import view.ModelRole;

public interface PositionRole extends Serializable{

	void search(PlayerRole rabbit);

	void moveSouth();

	void moveNorth();

	void moveEast();

	void moveWest();

	boolean isOnNorthBorder();

	boolean isOnSouthBorder();

	boolean isOnEastBorder();

	boolean isOnWestBorder();

	void loadImage(ButtonRole[][] buttons, ModelRole model, PlayerRole player);


}
