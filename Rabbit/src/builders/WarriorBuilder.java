package builders;

import java.io.Serializable;
import java.util.List;

import buttons.ButtonRole;
import field.Field;
import players.PlayerRole;
import players.PowerRole;
import players.Rabbit;
import players.WarriorRabbitPower;
import position.PositionRoleState;
import view.ModelRole;

public class WarriorBuilder implements PlayerBuilderRole,Serializable {
	private PlayerBuilderRole innerBuilder;

	public WarriorBuilder() {
		this.innerBuilder = new RabbitBuilder();
	}

	@Override
	public void addRabbit(int x, int y, List<PlayerRole> playersOnField, Field field, ModelRole model,
			ButtonRole button) {
		PositionRoleState positionState = buildPositionState(x, y, field);
		PowerRole rabbitPower = new WarriorRabbitPower();
		PlayerRole rabbit = new Rabbit(positionState, model, button,rabbitPower);
		playersOnField.add(rabbit);

	}

	@Override
	public PositionRoleState buildPositionState(int x, int y, Field field) {
		return innerBuilder.buildPositionState(x, y, field);
	}

}
