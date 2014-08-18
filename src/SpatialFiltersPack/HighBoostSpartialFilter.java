package SpatialFiltersPack;

import constraintsPack.EFilterKey;

public class HighBoostSpartialFilter extends GenericSpatialFilter {

	private double Kfactor;
	
	public HighBoostSpartialFilter(double k) {
		super(EFilterKey.HIGHBOOST, 1, null);
		this.Kfactor = k;
		double[][] kernel = new double[][]{
				{-1,-1,-1},
				{-1,(9*Kfactor) -1 ,-1},
				{-1,-1,-1}
		};
		this.setKernel(kernel);
		
	}

	public double getKfactor() {
		return Kfactor;
	}

	public void setKfactor(double kfactor) {
		Kfactor = kfactor;
	}

	@Override
	public double execute(double[][] image, int xCentral, int yCentral) {
		return Math.round((1.0/9.0) * super.execute(image, xCentral, yCentral));
	}

}
