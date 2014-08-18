package SpatialFiltersPack;

import java.util.ArrayList;
import java.util.Collections;

import constraintsPack.EFilterKey;

public class Midpoint extends GenericSpatialFilter {

	public Midpoint(int radius) {
		super(EFilterKey.MIDPOINT, radius, null);
		
	}

	@Override
	public double execute(double[][] image, int xc, int yc) {
		ArrayList<Double> list = new ArrayList<Double>();		
		for(int s = -this.getFilterRadius() ; s <=this.getFilterRadius()  ; s++ ){
			for(int t = -this.getFilterRadius() ; t <= this.getFilterRadius() ; t++){
				list.add(image[xc+s][yc+t]);
			}
		}
		Collections.sort(list);		
		return ((0.5) * (list.get(0) + list.get(list.size() -1)));
	}

	
}
