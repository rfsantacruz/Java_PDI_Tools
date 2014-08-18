package SpatialFiltersPack;

import java.util.ArrayList;
import java.util.Collections;

import constraintsPack.EFilterKey;

public class GeometricMean extends GenericSpatialFilter{

	public GeometricMean(int radius) {
		super(EFilterKey.GEOMETRICMEAN, radius,null);	
	}

	@Override
	public double execute(double[][] image, int xc, int yc) {
		double ret = 1;	
		double l = (this.getFilterRadius() * 2) + 1;
		for(int s = -this.getFilterRadius() ; s <=this.getFilterRadius()  ; s++ ){
			for(int t = -this.getFilterRadius() ; t <= this.getFilterRadius() ; t++){
				ret = ret * image[xc+s][yc+t];
			}
		}			
		return Math.pow(ret, (1.0/(l*l)));
	}

	
}
