package builders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import application.Game;
import buttons.ButtonRole;
import collectibles.BlankState;
import collectibles.CollectibleRole;
import collectibles.CollectibleStateRole;
import collectibles.EggRole;
import collectibles.EggState;
import field.Field;
import field.InsideParcel;
import field.OutsideParcel;
import field.ParcelRole;
import players.PlayerRole;
import view.ModelRole;

public class GameBuilder implements Serializable {

	private Field field;
	private List<PlayerRole> playersOnField;
	private ParcelRole[][] parcel;
	private ButtonRole[][] buttons;
	private ParcelBuilder parcelBuilder;
	private PlayerBuilderRole playersBuilder;
	private PlayerDispatcher playerDispatcher;
	
	private CollectibleBuilderRole collectibleBuilder;
	private CollectibleDispatcher collectibleDispatcher;

	public Game build(int numberOfLines, ButtonRole[][] buttons) {

		playersOnField = new ArrayList<PlayerRole>();
		parcelBuilder = new ParcelBuilder();
		field = new Field(playersOnField);
		playerDispatcher = new PlayerDispatcher();
		collectibleDispatcher = new CollectibleDispatcher();
		parcel = parcelBuilder.build(numberOfLines, field);
		
		this.buttons = buttons;
		field.setParcel(parcel);
		field.setButtons( buttons );
		return new Game(field);
	}

	public void addEgg(int x, int y, CollectibleRole collectible) {
	
		CollectibleStateRole blankState = parcelBuilder.buildEggLessState();
		collectibleBuilder = collectibleDispatcher.build(collectible);
		
		parcel[x][y] = collectibleBuilder.addCollectible( buttons[x][y],blankState, collectible );
		
	}

	public void addRabbit(int x, int y, ModelRole model, ButtonRole button) {
		
		
		playersBuilder = playerDispatcher.build(model);
		playersBuilder.addRabbit(x, y, playersOnField, field, model, button);

	}

}
