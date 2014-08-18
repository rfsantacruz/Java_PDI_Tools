package MoforlogicOperationsPack;

import constraintsPack.EFilterKey;
import constraintsPack.IBinaryContant;

public class DilatationMorfologicOperator  extends GenericMorfologicOperator{

	public DilatationMorfologicOperator( int[][] es) {
		super(EFilterKey.DILATATION, es);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(double[][] imgSource, double[][] imageTarget,
			int xCentral, int yCentral) {
		int heigthRadius , a;
		int widthRadius , b;
		a = heigthRadius = this.getStreucturantElementHeigth()/2;
		b = widthRadius =this.getStreucturantElementWidth()/2;
		boolean macth = false;						
		
		for(int s = -a ; s <=a  ; s++ ){
			for(int t = -b ; t <= b ; t++){
				if(this.getStructurantElement()[s+heigthRadius][t+widthRadius] == IBinaryContant.CENTRAL 
						&& imgSource[xCentral+s][yCentral+t] == IBinaryContant.ONE )
					macth =true;
				
							
			}
		}
		if(macth){
			for(int s = -a ; s <=a  ; s++ ){
				for(int t = -b ; t <= b ; t++){
					if(this.getStructurantElement()[s+heigthRadius][t+widthRadius] == IBinaryContant.ONE || this.getStructurantElement()[s+heigthRadius][t+widthRadius] == IBinaryContant.CENTRAL || this.getStructurantElement()[s+heigthRadius][t+widthRadius] == IBinaryContant.DONTCARE) 
						imageTarget[xCentral+s][yCentral+t]	 = IBinaryContant.ONE;							
								
				}
			}			
		}
	}
		
}
