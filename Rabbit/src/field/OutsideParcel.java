package field;

import java.io.Serializable;

import application.GameFieldRole;
import buttons.ButtonRole;
import players.PlayerRole;
import view.ModelRole;

public class OutsideParcel implements ParcelRole,Serializable {

	private GameFieldRole field;

	public OutsideParcel(Field field) {
		this.field = field;
	}

	@Override
	public void search(PlayerRole rabbit) {
		rabbit.die();
		if (rabbit.isAlive()) {
			rabbit.getBackInGame();
			System.out.println("alive");
		} else {
			field.checkBestScore(rabbit);
			field.removePlayer(rabbit);
		}

	}

	@Override
	public void loadImage(ButtonRole button) {
		// TODO Auto-generated method stub
		
	}

}
