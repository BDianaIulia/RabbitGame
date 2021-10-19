package builders;

import java.io.Serializable;
import java.util.HashMap;

import buttons.ButtonRole;
import players.PlayerRole;
import position.PositionRoleState;
import view.ModelRole;

public class PlayerDispatcher implements Serializable{

	HashMap<String,PlayerBuilderRole> dispatcher;
	PlayerBuilderRole rabbitBuilder;
	PlayerBuilderRole warriorBuilder;
	PlayerBuilderRole keyBuilder;
	
	public PlayerDispatcher() {
		super();
		this.dispatcher = new HashMap<String,PlayerBuilderRole>();
		rabbitBuilder = new RabbitBuilder();
		warriorBuilder = new WarriorBuilder();
		keyBuilder = new KeyBuilder();
		
		dispatcher.put("Crazy rabbit", rabbitBuilder);
		dispatcher.put("Carrot warrior", warriorBuilder);
		dispatcher.put("Key rabbit", keyBuilder);
		
	}
	
	public PlayerBuilderRole build(ModelRole model) {
		// TODO Auto-generated method stub
		return dispatcher.get(model.getName());
	}

}
