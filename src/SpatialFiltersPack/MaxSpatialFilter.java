package SpatialFiltersPack;

import java.util.ArrayList;
import java.util.Collections;

import constraintsPack.EFilterKey;

public class MaxSpatialFilter extends GenericSpatialFilter {

	public MaxSpatialFilter(int radius) {
		super(EFilterKey.MAX,radius,null );				
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
		return list.get(list.size() -1);
		
	}

}
