package intensityFiltersPack;

import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;
import GenericClass.GenericFilter;

public abstract class GenericIntensityFilter extends GenericFilter {

	public GenericIntensityFilter( EFilterKey identity) {
		super(identity, EFilterType.INTENSITYFILTERS);
		// TODO Auto-generated constructor stub
	}

	public abstract double execute(double r);

}
