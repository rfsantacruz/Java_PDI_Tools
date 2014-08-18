package SpatialFiltersPack;

import constraintsPack.EFilterKey;

public class UnsharpenMaskSpartialFilter extends GenericSpatialFilter{

	public UnsharpenMaskSpartialFilter(int radius) {
		super(EFilterKey.UNSHARPENMASK,radius,null);
		
	}

	@Override
	public double execute(double[][] image, int xCentral, int yCentral) {
		// TODO Auto-generated method stub
		return 0;
	}

}
