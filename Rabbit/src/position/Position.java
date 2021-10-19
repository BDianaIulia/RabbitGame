package position;

import java.io.Serializable;

import buttons.ButtonRole;
import field.ParcelFieldRole;
import players.PlayerRole;
import view.ModelRole;

public class Position implements PositionRole,Serializable {

	private int x;
	private int y;
	private ParcelFieldRole field;

	public Position(int x, int y, ParcelFieldRole field) {
		this.x = x;
		this.y = y;
		this.field = field;
	}

	@Override
	public void search(PlayerRole rabbit) {
		
		field.search(rabbit, x, y);

	}

	@Override
	public void moveSouth() {

		y--;

	}
	
	@Override
	public void moveNorth() {

		y++;

	}
	
	@Override
	public void moveEast() {

		x++;

	}
	
	@Override
	public void moveWest() {

		x--;

	}

	@Override
	public boolean isOnNorthBorder() {

		return y==field.getMaxY();
	}

	@Override
	public boolean isOnSouthBorder() {
		// TODO Auto-generated method stub
		return y == 0;
	}

	@Override
	public boolean isOnEastBorder() {
		// TODO Auto-generated method stub
		return x == field.getMaxX();
		
	}

	@Override
	public boolean isOnWestBorder() {
		// TODO Auto-generated method stub
		return x == 0;
	}

	@Override
	public void loadImage(ButtonRole[][] buttons,ModelRole model,PlayerRole player) {
		player.changeButton(buttons[x][y]);
	}



}
