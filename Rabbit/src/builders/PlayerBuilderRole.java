package builders;

import java.io.Serializable;
import java.util.List;

import buttons.ButtonRole;
import field.Field;
import players.PlayerRole;
import position.PositionRoleState;
import view.ModelRole;

public interface PlayerBuilderRole extends Serializable{

	void addRabbit(int x, int y, List<PlayerRole> playersOnField, Field field, ModelRole model, ButtonRole button);

	PositionRoleState buildPositionState(int x, int y, Field field);

}
