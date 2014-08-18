package MoforlogicOperationsPack;

import constraintsPack.EFilterKey;
import constraintsPack.IBinaryContant;

public class ErosionMorfologicOperator extends GenericMorfologicOperator{

	public ErosionMorfologicOperator( int[][] es) {
		super(EFilterKey.EROSION, es);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(double[][] imgSource, double[][] imageTarget,
			int xCentral, int yCentral) {
		int heigthRadius , a;
		int widthRadius , b;
		a = heigthRadius = this.getStreucturantElementHeigth()/2;
		b = widthRadius =this.getStreucturantElementWidth()/2;
		boolean macth = true;
		for(int s = -a ; s <=a  ; s++ ){
			for(int t = -b ; t <= b ; t++){
				if( this.getStructurantElement()[s+heigthRadius][t+widthRadius] != IBinaryContant.CENTRAL 
						&& (this.getStructurantElement()[s+heigthRadius][t+widthRadius] != IBinaryContant.DONTCARE)
						&& (this.getStructurantElement()[s+heigthRadius][t+widthRadius] != (imgSource[xCentral+s][yCentral+t])))
						macth = false;
			}
		}
		if(macth){
			for(int s = -a ; s <=a  ; s++ ){
				for(int t = -b ; t <= b ; t++){
					if(this.getStructurantElement()[s+heigthRadius][t+widthRadius] == IBinaryContant.CENTRAL)
						imageTarget[xCentral+s][yCentral+t] = IBinaryContant.ONE;						
								
				}
			}						
		}
	}

}
