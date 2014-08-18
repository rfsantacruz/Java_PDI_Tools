package intensityFiltersPack;

import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;
import GenericClass.GenericFilter;

public class Logaritmic extends GenericIntensityFilter {

	private double C;
	
	public Logaritmic( double c) {
		super(EFilterKey.LOGARITMIC);
		this.C = c;
	}

	
	public double execute(double r) {
		return C * Math.log(r + 1);
	}

}
