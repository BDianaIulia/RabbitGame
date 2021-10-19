package players;

import java.io.Serializable;

public interface PlayerStatusRole extends Serializable{
	public boolean isAlive();

	public void die();

	public void getCaught();

	public boolean isCaught();

	public void escape();

	public void addLife();

	public void giveLife(PlayerRole warriorRabbit);

}
