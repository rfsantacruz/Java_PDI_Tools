package SpatialFiltersPack;

import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;
import GenericClass.GenericFilter;

public abstract class GenericSpatialFilter extends GenericFilter {
//filtros de tamanho impar e o meor de 3x3
	private double[][] Kernel;
	private int filterRadius;	
	
	public double[][] getKernel() {
		return Kernel;
	}
	public GenericSpatialFilter(EFilterKey key,int radius, double[][] kernel){
		super(key,EFilterType.SPATIALFILTERS);		
		this.Kernel = kernel;
		this.filterRadius = radius;
	}
	public void setKernel(double[][] kernel) {
		Kernel = kernel;
	}
		
	public double execute(double[][] image,int xc, int yc){
		double result = 0;
		int a = filterRadius;
		int b = filterRadius;
		for(int s = -a ; s <=a  ; s++ ){
			for(int t = -b ; t <= b ; t++){
				result += Kernel[s+filterRadius][t+filterRadius]*image[xc+s][yc+t];
			}
		}
		return result;
	}
	public void setFilterRadius(int filterRadius) {
		this.filterRadius = filterRadius;
	}

	public int getFilterRadius() {
		return filterRadius;
	}

	
}
