package field;

import java.io.Serializable;

import players.PlayerRole;

public interface ParcelFieldRole extends Serializable{

	void search(PlayerRole rabbit, int x, int y);

	int getMaxY();

	int getMaxX();


}
