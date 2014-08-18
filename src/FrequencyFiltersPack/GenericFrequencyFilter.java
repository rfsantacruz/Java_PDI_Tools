package FrequencyFiltersPack;

import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;
import GenericClass.GenericFilter;

public class GenericFrequencyFilter extends GenericFilter {

	
	public GenericFrequencyFilter(EFilterKey identity) {
		super(identity,EFilterType.FREQUENCYFILTERS);		
	}
	
	public double[][] execute(double[][] frequencyImg ){
		double[][] result = new double[frequencyImg.length][frequencyImg[0].length];
		for(int u = 0 ; u< frequencyImg.length; u++){
			for(int v = 0 ; v< frequencyImg[0].length; v++){
				result[u][v] = this.functionFilter(frequencyImg[u][v],u,v);
			}			
		}
		return result;
	}

	
	public double  functionFilter(double frequency,int u, int v){
		return 0;
	}
	
	
}
