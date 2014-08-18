package FrequencyFiltersPack;

import java.util.ArrayList;

import intensityFiltersPack.GenericIntensityFilter;
import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;
import GenericClass.GenericFilter;
import ProcessorPack.IFilterExecutor;

public class FrequencyFilterExecutor implements IFilterExecutor {

	
	private GenericFrequencyFilter Filter;
	
	
	@Override
	public double[][] applyFilter(double[][] image) {
		double[][] centeredImage = this.CenterImage(image);		
		System.out.println("Centered");
		
		ArrayList<double[][]> frequencyImg = this.DiscreteFourierTransform(centeredImage);		
		System.out.println(" To Frequency");		
		
		ArrayList<double[][]> filteredImage = new ArrayList<double[][]>();				
		filteredImage.add(Filter.execute(frequencyImg.get(0)));
		filteredImage.add(Filter.execute(frequencyImg.get(1)));
		System.out.println("Filtered");
		
		double[][] timeImg = this.InverseDiscreteFourierTransform(filteredImage);		
		System.out.println("Back to Time");
		
		double[][] resultImage = this.CenterImage(timeImg);
		System.out.println("Centered Again");
		
		return resultImage;
	}

	private double[][] CenterImage(double[][] image) {
		double[][] ceneteredImage = new double[image.length][image[0].length];
		for(int u = 0 ; u<image.length ; u++){
			for(int v = 0 ; v<image[0].length ; v++){
				ceneteredImage[u][v] = image[u][v] * Math.pow((-1.0), u+v);
			}
		}
		return ceneteredImage;
	}

	private double[][] InverseDiscreteFourierTransform(ArrayList<double[][]> images) {
		
		double M = images.get(0).length;
		double N = images.get(1)[0].length;
		
		double[][] frequencyImageReal = images.get(0);
		double[][] frequencyImageImaginary = images.get(1);
		
		double[][] timeImage = new double[(int)M][(int)N];
						
		for(int x=0;x<M;x++){
			for(int y=0;y<N;y++){		
				for(int u=0;u<M;u++){
					for(int v=0;v<N;v++){
						 timeImage[x][y] += (frequencyImageReal[u][v] * Math.cos(2*Math.PI*(((x*u)/M)+((y*v)/N)))) 
						 - (frequencyImageImaginary[u][v] * Math.sin(2*Math.PI*(((x*u)/M)+((y*v)/N))));						     
					}
				}
				timeImage[x][y] = timeImage[x][y] / M*N;
			}
		}
		return timeImage;
	}

	private ArrayList<double[][]> DiscreteFourierTransform(double[][] image) {
		ArrayList<double[][]> result = new ArrayList<double[][]>();
		double[][] realFrequencyImage = new double[image.length][image[0].length];
		double[][] imaginaryFrequencyImage = new double[image.length][image[0].length];
		double M = image.length;
		double N = image[0].length;
		for(int u=0;u<image.length;u++){
			for(int v=0;v<image[0].length;v++){		
				for(int x=0;x<image.length;x++){
					for(int y=0;y<image[0].length;y++){
						realFrequencyImage[u][v] += image[x][y] * Math.cos(2*Math.PI*((u*x/M)+(v*y/N)));
						imaginaryFrequencyImage[u][v] += image[x][y] * (- Math.sin(2*Math.PI*((u*x/M)+(v*y/N))));	
					}
				}
			}
		}
		result.add(realFrequencyImage);
		result.add(imaginaryFrequencyImage);
		return result;
	}

	@Override
	public EFilterKey getFilterIdentity() {
		return Filter.getIdentity();
	}

	@Override
	public EFilterType getTypeFilter() {
		return EFilterType.FREQUENCYFILTERS;
	}

	@Override
	public void setFilter(GenericFilter filter) {
		this.Filter = (GenericFrequencyFilter)filter;
		
	}

	@Override
	public GenericFilter getFilter() {
		return this.Filter;
	}

}
