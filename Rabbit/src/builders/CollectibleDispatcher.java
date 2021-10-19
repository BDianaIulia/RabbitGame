package builders;

import java.io.Serializable;
import java.util.HashMap;

import collectibles.CollectibleRole;
import view.ModelRole;

public class CollectibleDispatcher implements Serializable {

	HashMap<String,CollectibleBuilderRole> dispatcher;
	CollectibleBuilderRole eggBuilder;
	CollectibleBuilderRole trapBuilder;
	CollectibleBuilderRole spiderWebBuilder;
	CollectibleBuilderRole extraLifeBuilder;
	CollectibleBuilderRole carrotBuilder;
	
	public CollectibleDispatcher() {
		super();
		this.dispatcher = new HashMap<String,CollectibleBuilderRole>();
		eggBuilder = new EggBuilder();
		trapBuilder = new TrapBuilder();
		spiderWebBuilder = new SpiderWebBuilder();
		extraLifeBuilder = new ExtraLifeBuilder();
		carrotBuilder = new CarrotBuilder();
		
		dispatcher.put("Egg", eggBuilder);
		dispatcher.put("Trap", trapBuilder);
		dispatcher.put("Spider Web", spiderWebBuilder);
		dispatcher.put("Extra Life", extraLifeBuilder);
		dispatcher.put("Carrot", carrotBuilder);
		
	}
	
	public CollectibleBuilderRole build(CollectibleRole collectible) {
		String modelName = collectible.getModelName();
		return dispatcher.get(modelName);
	}

}
