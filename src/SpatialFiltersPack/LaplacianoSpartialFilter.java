package SpatialFiltersPack;

import constraintsPack.EFilterKey;

public class LaplacianoSpartialFilter extends GenericSpatialFilter{

	private boolean DiagonalIsConsidered;
	
	public boolean isDiagonalIsConsidered() {
		return DiagonalIsConsidered;
	}

	public void setDiagonalIsConsidered(boolean diagonalIsConsidered) {
		DiagonalIsConsidered = diagonalIsConsidered;
	}

	public LaplacianoSpartialFilter(boolean diagonalIsConsidered) {
		super(EFilterKey.LAPLACIANO, 1, null);
		double[][] kernel = null;
		if(diagonalIsConsidered){
			kernel = new double[][]{
				{-1,-1,-1},
				{-1,8,-1},
				{-1,-1,-1}
				
			};
		}else{
			kernel = new double[][]{
					{0,-1,0},
					{-1,4,-1},
					{0,-1,0}
					
				};
		}
		this.setKernel(kernel);
		
	}

	@Override
	public double execute(double[][] image, int xc, int yc) {
		  return super.execute(image, xc, yc);
	}	
}
