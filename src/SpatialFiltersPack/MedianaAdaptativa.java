package SpatialFiltersPack;

import java.util.ArrayList;
import java.util.Collections;

import constraintsPack.EFilterKey;

public class MedianaAdaptativa extends GenericSpatialFilter {

	private int RadiusMAX;
	
	public MedianaAdaptativa( int radius, int radiusMAX) {
		super(EFilterKey.ADAPTATIVEMEDIANA, radius, null);
		this.RadiusMAX = radiusMAX;		
	}
	
	@Override
	public double execute(double[][] image, int xc, int yc) {
		return this.Execution(image, xc, yc, this.getFilterRadius() , this.getRadiusMAX());
	}

	private double Execution(double[][] image, int xc, int yc, int currentRadius,int maxRadius){
		
	
		ArrayList<Double> list = new ArrayList<Double>();		
		for(int s = -currentRadius ; s <=this.getFilterRadius()  ; s++ ){
			for(int t = -currentRadius ; t <= this.getFilterRadius() ; t++){
				list.add(image[xc+s][yc+t]);
			}
		}
		Collections.sort(list);		
		
		double Zmin = list.get(0);
		double Zmax = list.get(list.size() - 1);
		double Zmed = list.get((list.size()/2)+1); 
		double z = image[xc][yc];
		
		while(true){
			
			double A1 = Zmed - Zmin;
			double A2 = Zmed - Zmax;
			
			
			if(A1 > 0 && A2<0){
				double B1 = z-Zmin;
				double B2 = z - Zmax;
				
				if(B1>0 && B2<0)
					return z;
				else
					return Zmed;
			}else 
				currentRadius = currentRadius + 1;			
			
			if(currentRadius <= maxRadius)
				continue;
			else
				return z;
		}
				
	}
	
	public int getRadiusMAX() {
		return RadiusMAX;
	}

	public void setRadiusMAX(int radiusMAX) {
		RadiusMAX = radiusMAX;
	}

}
