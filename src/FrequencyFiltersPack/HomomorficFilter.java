package FrequencyFiltersPack;

import constraintsPack.EFilterKey;

public class HomomorficFilter extends GenericFrequencyFilter {

	private int P;
	private int Q;
	private double C;
	private double D0;
	private double Yl;
	private double Yh;
	
	
	public HomomorficFilter(int p, int q, double c,
			double d0, double yl, double yh) {
		this();
		
		P = p;
		Q = q;
		C = c;
		D0 = d0;
		Yl = yl;
		Yh = yh;
	}
	
	private HomomorficFilter() {
		super(EFilterKey.HOMOMORFIC);
		// TODO Auto-generated constructor stub
	}
	
	

	public double  functionFilter(double frequency, int u, int v){
		double D = Math.pow(((Math.pow((u-P/2.0),2) + Math.pow(v-Q/2.0,2))),0.5);
		double coef = -C*(Math.pow(D, 2)/Math.pow(D0, 2));		
		return frequency * ( (Yh-Yl) * (1-Math.exp(coef)) + Yl) ;
	}
	
	
}
