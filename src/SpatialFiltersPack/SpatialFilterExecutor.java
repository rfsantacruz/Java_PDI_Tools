package SpatialFiltersPack;

import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;
import GenericClass.GenericFilter;
import ProcessorPack.IFilterExecutor;



public class SpatialFilterExecutor implements IFilterExecutor {

	private GenericSpatialFilter filter;
	
	public GenericSpatialFilter getFilter() {
		return filter;
	}	

	@Override
	public String toString() {
		return filter.toString();
	}

	private double[][] execute(double[][] img){
		double[][] result = new double[img.length][img[0].length]; 		
		for (int x = filter.getFilterRadius(); x < img.length - filter.getFilterRadius(); x++) {
			for (int y = filter.getFilterRadius(); y < img[0].length - filter.getFilterRadius(); y++) {			
				double s = filter.execute(img,x,y);
				result[x][y] = s;
			}
		}
		return result;
	}

	@Override
	public double[][] applyFilter(double[][] image) {
		return this.execute(image);
	}

	@Override
	public EFilterKey getFilterIdentity() {
		return filter.getIdentity();
		
	}

	@Override
	public EFilterType getTypeFilter() {
		return filter.getType();
	}

	@Override
	public void setFilter(GenericFilter filter) {
		this.filter = (GenericSpatialFilter) filter;
		
	}
}
