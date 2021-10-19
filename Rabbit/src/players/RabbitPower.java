package players;

import java.io.Serializable;

public class RabbitPower implements PowerRole,Serializable {
	@Override
	public void execute(PlayerRole otherRabbit, PlayerRole thisRabbit) {
		checkWarriorType(otherRabbit,thisRabbit);
		checkKeyType(otherRabbit,thisRabbit);
		
	}
	private void checkWarriorType(PlayerRole otherRabbit,PlayerRole thisRabbit) {
		if (otherRabbit.isWarriorRabbit()) {
			otherRabbit.execute(thisRabbit);
			thisRabbit.die();
		}

	}
	private void checkKeyType(PlayerRole otherRabbit,PlayerRole thisRabbit) {
		if (otherRabbit.isKeyRabbit()) {
			otherRabbit.execute(thisRabbit);
		}
	}

	@Override
	public boolean isNormalRabbit() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isWarriorRabbit() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isKeyRabbit() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
