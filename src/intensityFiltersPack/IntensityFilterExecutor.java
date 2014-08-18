package intensityFiltersPack;

import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;
import GenericClass.GenericFilter;
import ProcessorPack.IFilterExecutor;

public class IntensityFilterExecutor implements IFilterExecutor{
	
	private GenericIntensityFilter filter;
		

	public double[][] execute(double[][] img){
		double[][] result = new double[img.length][img[0].length]; 
		for (int x = 0; x < img.length; x++) {
			for (int y = 0; y < img[x].length; y++) {
				double s = img[x][y]; 
				result[x][y] = filter.execute(s);
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
		this.filter = (GenericIntensityFilter) filter;
		
	}

	@Override
	public GenericFilter getFilter() {		
		return this.filter;
	}
	
}
