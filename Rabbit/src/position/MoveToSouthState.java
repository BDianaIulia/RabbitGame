package position;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;
import view.ModelRole;

public class MoveToSouthState implements PositionRoleState, Serializable {

	PositionRole innerPosition;
	PositionRoleState nextState;

	public MoveToSouthState(PositionRole innerPosition) {
		super();
		this.innerPosition = innerPosition;
	}

	@Override
	public void move() {

		innerPosition.moveSouth();

	}

	@Override
	public void search(PlayerRole rabbit) {

		innerPosition.search(rabbit);

	}

	@Override
	public PositionRoleState next() {

		return nextState;
	}

	public boolean isInitialState() {

		return innerPosition.isOnNorthBorder();

	}

	public void setNextState(PositionRoleState nextState) {
		this.nextState = nextState;
	}

	@Override
	public void loadImage(ButtonRole[][] buttons,ModelRole model, PlayerRole player) {
		innerPosition.loadImage(buttons,model,player);
		
	}


}
