package intensityFiltersPack;

import constraintsPack.EFilterKey;

public class ExpIntensityFilter extends GenericIntensityFilter {

	public ExpIntensityFilter() {
		super(EFilterKey.EXPONENCIAL);
		
	}

	@Override
	public double execute(double r) {
		return Math.exp(r);
	}

}
