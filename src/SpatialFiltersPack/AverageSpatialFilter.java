package SpatialFiltersPack;

import constraintsPack.EFilterKey;

public class AverageSpatialFilter extends GenericSpatialFilter {

	public AverageSpatialFilter(int radius) {		
		super(EFilterKey.AVERAGEFILTER,radius,null );	
		
		double[][] kernel = new double[2*radius + 1][2*radius + 1];
		for(int x = 0 ; x < kernel.length ; x++){
			for(int y = 0 ; y < kernel[0].length ; y++){
				kernel[x][y] = 1.0/(kernel.length*kernel[0].length);
			}
		}
		this.setKernel(kernel);
	}	

	@Override
	public double execute(double[][] image, int xCentral, int yCentral) {				
		return super.execute(image, xCentral, yCentral);
	}
}