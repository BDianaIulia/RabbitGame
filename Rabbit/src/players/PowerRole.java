package players;

import java.io.Serializable;

public interface PowerRole extends Serializable {

	void execute(PlayerRole otherRabbit, PlayerRole thisRabbit);

	boolean isNormalRabbit();

	boolean isWarriorRabbit();

	boolean isKeyRabbit();

}
