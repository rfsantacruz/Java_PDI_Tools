package SpatialFiltersPack;

import constraintsPack.EFilterKey;

public class HighPassSpatialFilter extends GenericSpatialFilter {

	private boolean DiagonalIsConsidered;
	
	public HighPassSpatialFilter( boolean diagonalIsConsidered) {
		super(EFilterKey.HIGHPASS, 1,null);
		this.DiagonalIsConsidered = diagonalIsConsidered;		
		double[][] kernel = null;
		if(this.DiagonalIsConsidered){
			kernel = new double[][]{
				{-1,-1,-1},
				{-1,8 ,-1},
				{-1,-1,-1}
		};
		}else{
			kernel = new double[][]{
					{0,-1,0},
					{-1,8 ,-1},
					{0,-1,0}
		};
		}
		this.setKernel(kernel);
	}

	public boolean isDiagonalIsConsidered() {
		return DiagonalIsConsidered;
	}

	public void setDiagonalIsConsidered(boolean diagonalIsConsidered) {
		DiagonalIsConsidered = diagonalIsConsidered;
	}

	@Override
	public double execute(double[][] image, int xCentral, int yCentral) {
		return Math.round((1.0/9.0) * super.execute(image, xCentral, yCentral));
	}

	

	
	
}
