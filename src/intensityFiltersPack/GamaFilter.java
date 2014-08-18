package intensityFiltersPack;

import constraintsPack.EFilterKey;


public class GamaFilter extends GenericIntensityFilter {

	private double C;
	private double Y;
	
	public GamaFilter( double c, double y) {
		super(EFilterKey.GAMA);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute(double r) {
		return C * Math.pow(r, Y);
	}
	

	public double getC() {
		return C;
	}

	public void setC(double c) {
		C = c;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}

	
}
