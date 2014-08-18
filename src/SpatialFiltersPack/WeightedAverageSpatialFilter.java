package SpatialFiltersPack;

import constraintsPack.EFilterKey;

public class WeightedAverageSpatialFilter extends GenericSpatialFilter {

	public WeightedAverageSpatialFilter() {
		super(EFilterKey.WEIGHTEDAVERAGE,1,null);			
		double[][] kernel = new double[][]{
				{1,2,1},
				{2,4,2},
				{1,2,1}
		};				
		this.setKernel(kernel);
	}
	
	public double execute(double[][] image, int xCentral, int yCentral) {
		return Math.round((1.0/16.0) * super.execute(image, xCentral, yCentral));
	}
}
