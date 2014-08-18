package SpatialFiltersPack;

import java.util.ArrayList;
import java.util.Collections;

import constraintsPack.EFilterKey;


public class MinSpatialFilter extends GenericSpatialFilter {

	public MinSpatialFilter( int radius) {
		super(EFilterKey.MIN, radius,null);
	}

	@Override
	public double execute(double[][] image, int xCentral, int yCentral) {
		ArrayList<Double> list = new ArrayList<Double>();		
		for(int s = -this.getFilterRadius() ; s <=this.getFilterRadius()  ; s++ ){
			for(int t = -this.getFilterRadius() ; t <= this.getFilterRadius() ; t++){
				list.add(image[xCentral+s][yCentral+t]);
			}
		}
		Collections.sort(list);		
		return list.get((0));
	}

}
