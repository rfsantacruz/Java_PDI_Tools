package SetOperationsPack;

import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;
import GenericClass.GenericFilter;
import ProcessorPack.IDoubleOperandExecutor;


public class SetOperationExecutor implements IDoubleOperandExecutor {

	GenericSetOperation operation = null;
	
	
	public double[][] applyFilter(double[][] imageA, double[][] imageB) {
		double[][] result = new double[imageA.length][imageA[0].length]; 
		for (int x = 0; x < imageA.length; x++) {
			for (int y = 0; y < imageA[x].length; y++) {
				result[x][y] = operation.execute((int)imageA[x][y],(int)imageB[x][y]);
			}
		}
		return result;
	}

	
	public EFilterKey getFilterIdentity() {
		return operation.getIdentity();
	}

	
	public EFilterType getTypeFilter() {
		return operation.getType();

	}

	public void setFilter(GenericFilter filter) {
		operation = (GenericSetOperation) filter;
		
	}

	public GenericFilter getFilter() {
		return operation;
	}


}
