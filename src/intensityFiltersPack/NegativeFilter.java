package intensityFiltersPack;

import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;
import GenericClass.GenericFilter;

public class NegativeFilter extends GenericIntensityFilter {

	private double MaxLevel;
	public NegativeFilter(double maxLevel){
		super(EFilterKey.NEGATIVA);
		this.MaxLevel = maxLevel;
	}
	
	@Override
	public double execute(double r) {
		return (MaxLevel - 1) - r;
	}
	
	public double getMaxLevel() {
		return MaxLevel;
	}

	public void setMaxLevel(double maxLevel) {
		MaxLevel = maxLevel;
	}


}
