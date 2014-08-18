package MoforlogicOperationsPack;

import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;
import GenericClass.GenericFilter;
import ProcessorPack.IFilterExecutor;

public class MorfologicOperatorExecutor implements IFilterExecutor {

	private GenericMorfologicOperator operator;
	
	@Override
	public EFilterKey getFilterIdentity() {
		return operator.getIdentity();
	}

	@Override
	public EFilterType getTypeFilter() {
		return operator.getType();
	}

	@Override
	public void setFilter(GenericFilter filter) {
		this.operator = (GenericMorfologicOperator)filter;
		
	}

	@Override
	public GenericFilter getFilter() {
		return this.operator;
	}

	@Override
	public double[][] applyFilter(double[][] image) {
		double[][] result = new double[image.length][image[0].length]; 		
		for (int x = operator.getStreucturantElementHeigth()/2; x < image.length - operator.getStreucturantElementHeigth(); x++) {
			for (int y = operator.getStreucturantElementWidth()/2; y < image[0].length - operator.getStreucturantElementWidth(); y++) {			
				operator.execute(image,result,x,y);				
			}
		}
		return result;
	}

}
