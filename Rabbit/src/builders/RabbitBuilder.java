package builders;

import java.io.Serializable;
import java.util.List;

import buttons.ButtonRole;
import field.Field;
import players.PlayerRole;
import players.PowerRole;
import players.Rabbit;
import players.RabbitPower;
import position.MoveToEastState;
import position.MoveToNorthState;
import position.MoveToSouthState;
import position.MoveToWestState;
import position.Position;
import position.PositionRole;
import position.PositionRoleState;
import view.ModelRole;

public class RabbitBuilder implements PlayerBuilderRole,Serializable {
	
	
	public void addRabbit(int x, int y, List<PlayerRole> playersOnField, Field field, ModelRole model, ButtonRole button) {

		PositionRoleState positionState = buildPositionState(x, y, field);
		PowerRole rabbitPower = new RabbitPower();
		PlayerRole rabbit = new Rabbit(positionState, model, button, rabbitPower);
		playersOnField.add(rabbit);
	}

	public PositionRoleState buildPositionState(int x, int y, Field field) {

		PositionRole innerPosition = new Position(x, y, field);

		MoveToNorthState moveToNorthState = new MoveToNorthState(innerPosition);
		MoveToEastState moveToEastState = new MoveToEastState(innerPosition);
		MoveToSouthState moveToSouthState = new MoveToSouthState(innerPosition);
		MoveToWestState moveToWestState = new MoveToWestState(innerPosition);

		wireState(moveToNorthState, moveToEastState, moveToSouthState, moveToWestState);

		return findInitialState(moveToNorthState);

	}

	private PositionRoleState findInitialState(MoveToNorthState moveToNorthState) {
		PositionRoleState currentState = moveToNorthState;
		while (true) {
			if (currentState.isInitialState())
				break;

			currentState = currentState.next();
		}

		return currentState;
	}

	private void wireState(MoveToNorthState moveToNorthState, MoveToEastState moveToEastState,
			MoveToSouthState moveToSouthState, MoveToWestState moveToWestState) {
		moveToNorthState.setNextState(moveToEastState);
		moveToEastState.setNextState(moveToSouthState);
		moveToSouthState.setNextState(moveToWestState);
		moveToWestState.setNextState(moveToNorthState);
	}
}
