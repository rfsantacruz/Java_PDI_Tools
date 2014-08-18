package intensityFiltersPack;

import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;
import GenericClass.GenericFilter;

public class GrayLevelSliceFilter extends GenericIntensityFilter {

	private double MinLevel;
	private double MaxLevel;
	private double EnphasizeLevel;
	private boolean MaintainOthers;
	
	
	public GrayLevelSliceFilter(double minlevel, double maxlevel,double enphasizeLevel , boolean mantainOthers  ) {
		super(EFilterKey.GRAYLEVELSLICE);
		this.MinLevel = minlevel;
		this.MaxLevel = maxlevel;
		this.EnphasizeLevel = enphasizeLevel;
		this.MaintainOthers = mantainOthers;
	}

	@Override
	public double execute(double r) {
		if( r>= this.MinLevel && r<= this.MaxLevel )
			return r*this.EnphasizeLevel;
		else
			return MaintainOthers ? r : 0; 				
	}

}
