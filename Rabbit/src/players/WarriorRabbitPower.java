package players;

import java.io.Serializable;

public class WarriorRabbitPower implements PowerRole, Serializable {

	@Override
	public void execute(PlayerRole otherRabbit, PlayerRole thisRabbit) {
		checkNormalType(otherRabbit, thisRabbit);
		checkKeyType(otherRabbit, thisRabbit);

	}

	private void checkKeyType(PlayerRole otherRabbit, PlayerRole thisRabbit) {
		if (otherRabbit.isKeyRabbit()) {
			otherRabbit.execute(thisRabbit);
			;
		}

	}

	private void checkNormalType(PlayerRole otherRabbit, PlayerRole thisRabbit) {
		if (otherRabbit.isNormalRabbit()) {
			otherRabbit.giveMeYourBasket(thisRabbit);
			otherRabbit.die();
		}

	}

	@Override
	public boolean isNormalRabbit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWarriorRabbit() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isKeyRabbit() {
		// TODO Auto-generated method stub
		return false;
	}

}
