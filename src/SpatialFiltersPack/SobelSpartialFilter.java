package SpatialFiltersPack;

import constraintsPack.EFilterKey;
import constraintsPack.ESobelOperatorType;

public class SobelSpartialFilter extends GenericSpatialFilter {
	
	
	public SobelSpartialFilter(ESobelOperatorType type) {
		super(EFilterKey.SOBEL,1,null);
		double[][] kernel = null;
		if(type.equals(ESobelOperatorType.Horizontal)){			
			kernel = new double[][]{
					{-1,-2,-1},
					{0,0,0},
					{1,2,1}
			};
		}else{
			kernel = new double[][]{
				{-1,0,1},
				{-2,0,2},
				{-1,0,1}
			};
		}
		this.setKernel(kernel);
	}
	 
	@Override
	public double execute(double[][] image, int xCentral, int yCentral) {
		return super.execute(image, xCentral, yCentral);
	}
	
}
