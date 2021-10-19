package builders;

import java.util.List;

import buttons.ButtonRole;
import field.Field;
import players.KeyRabbitPower;
import players.PlayerRole;
import players.PowerRole;
import players.Rabbit;
import position.PositionRoleState;
import view.ModelRole;

public class KeyBuilder implements PlayerBuilderRole {
	private PlayerBuilderRole innerBuilder;
	public KeyBuilder() {
		this.innerBuilder = new RabbitBuilder();
	}

	@Override
	public void addRabbit(int x, int y, List<PlayerRole> playersOnField, Field field, ModelRole model,
			ButtonRole button) {
		PositionRoleState positionState = buildPositionState(x, y, field);
		PowerRole rabbitPower = new KeyRabbitPower();
		PlayerRole rabbit = new Rabbit(positionState, model, button,rabbitPower);
		playersOnField.add(rabbit);

	}

	@Override
	public PositionRoleState buildPositionState(int x, int y, Field field) {
		return innerBuilder.buildPositionState(x, y, field);
	}

}
