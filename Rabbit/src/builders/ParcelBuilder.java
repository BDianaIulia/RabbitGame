package builders;

import java.io.Serializable;

import collectibles.BlankState;
import field.Field;
import field.InsideParcel;
import field.OutsideParcel;
import field.ParcelRole;

public class ParcelBuilder implements Serializable{
	private ParcelRole[][] parcel;

	public ParcelRole[][] build(int numberOfLines, Field field) {

		parcel = new ParcelRole[numberOfLines + 2][numberOfLines + 2];

		addOutsideParcels(numberOfLines,field);
		addInsideParcels(numberOfLines);
		return parcel;
	}

	private void addInsideParcels(int numberOfLines) {

		for (int i = 1; i <= numberOfLines; i++) {
			for (int j = 1; j <= numberOfLines; j++) {
				parcel[i][j] = buildInsideParcel();
			}

		}

	}

	private ParcelRole buildInsideParcel() {

		BlankState eggLessState = buildEggLessState();

		return new InsideParcel(eggLessState);
	}

	public BlankState buildEggLessState() {
		BlankState eggLessState = new BlankState();
		eggLessState.setNextState(eggLessState);
		return eggLessState;
	}

	private void addOutsideParcels(int numberOfLines, Field field) {

		for (int i = 0; i <= numberOfLines + 1; i++) {

			parcel[0][i] = new OutsideParcel(field);
			parcel[i][0] = new OutsideParcel(field);
			parcel[numberOfLines + 1][i] = new OutsideParcel(field);
			parcel[i][numberOfLines + 1] = new OutsideParcel(field);
		}

	}

}
