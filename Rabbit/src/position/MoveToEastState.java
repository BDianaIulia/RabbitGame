package position;

import java.io.Serializable;

import buttons.ButtonRole;
import players.PlayerRole;
import view.ModelRole;

public class MoveToEastState implements PositionRoleState,Serializable {
	
	PositionRole innerPosition;
	public MoveToEastState(PositionRole innerPosition) {
		
		this.innerPosition = innerPosition;
	}

	PositionRoleState nextState;

	@Override
	public void move() {
		
		innerPosition.moveEast();

	}

	@Override
	public void search(PlayerRole rabbit) {
		
		innerPosition.search(rabbit);
		
	}

	@Override
	public PositionRoleState next() {
		// TODO Auto-generated method stub
		return nextState;
	}

	@Override
	public boolean isInitialState() {
		// TODO Auto-generated method stub
		return innerPosition.isOnWestBorder();
	}

	public void setNextState(PositionRoleState nextState) {
		this.nextState = nextState;
	}

	@Override
	public void loadImage(ButtonRole[][] buttons,ModelRole model, PlayerRole player) {
		innerPosition.loadImage(buttons,model,player);
		
	}

	
}
