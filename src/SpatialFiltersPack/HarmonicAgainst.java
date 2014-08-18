package SpatialFiltersPack;

import constraintsPack.EFilterKey;

public class HarmonicAgainst extends GenericSpatialFilter {

	private double Q;
	
	public HarmonicAgainst( int radius, double q) {
		super(EFilterKey.AGAINSTHARMONICMEAN, radius, null);
		Q = q;
	}

	@Override
	public double execute(double[][] image, int xc, int yc) {
		double denominador = 0;
		double numerador = 0;		
		for(int s = -this.getFilterRadius() ; s <=this.getFilterRadius()  ; s++ ){
			for(int t = -this.getFilterRadius() ; t <= this.getFilterRadius() ; t++){
				numerador += Math.pow( image[xc+s][yc+t],(Q+1));
				denominador += Math.pow( image[xc+s][yc+t],(Q));
			}
		}			
		return denominador != 0 ? numerador/denominador : 0;
	}

	public double getQ() {
		return Q;
	}

	public void setQ(double q) {
		Q = q;
	}

	
}
