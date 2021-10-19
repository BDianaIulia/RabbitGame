package players;

import java.io.Serializable;

public class KeyRabbitPower implements PowerRole,Serializable {
	private boolean powerIsActive;
	public KeyRabbitPower() {
		super();
		powerIsActive = true;
	}

	
	private void block() {
		powerIsActive = false;
		
	}

	@Override
	public void execute(PlayerRole otherRabbit,PlayerRole thisRabbit) {
		if(powerIsActive) {
			checkWarriorType(otherRabbit);
			checkNormalType(otherRabbit);
			
		}
		
	}
	private void checkNormalType(PlayerRole otherRabbit) {
		if (otherRabbit.isNormalRabbit()) {
			otherRabbit.doubleBasket();
		}

	}
	private void checkWarriorType(PlayerRole otherRabbit) {
		if (otherRabbit.isWarriorRabbit()) {
			block();
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
		return false;
	}


	@Override
	public boolean isKeyRabbit() {
		// TODO Auto-generated method stub
		return true;
	}

}
