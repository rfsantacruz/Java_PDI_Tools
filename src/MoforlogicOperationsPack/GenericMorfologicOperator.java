package MoforlogicOperationsPack;

import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;
import GenericClass.GenericFilter;

public abstract class GenericMorfologicOperator extends GenericFilter {

	
	private int[][] es;	
	
	public GenericMorfologicOperator(EFilterKey identity, int[][] es) {
		super(identity, EFilterType.MORFOLOGICOPERATIONS);
		this.es = es;
		// TODO Auto-generated constructor stub
	}

	public abstract void execute(double[][] imgSource, double[][] imageTarget,int xCentral, int yCentral);
	
	public int getStreucturantElementWidth(){
		return this.es[0] != null ? (this.es[0].length) :0;
	}
	
	public int getStreucturantElementHeigth(){
		return this.es != null ? (this.es.length ) :0;
	}
	
	public void setStructurantElement(int[][] es) {
		this.es = es;
	}

	public int[][] getStructurantElement() {
		return es;
	}
}
