package HistogramPack;


import java.util.HashMap;
import GenericClass.Image;
import GenericClass.Tuple;
import ProcessorPack.ImageProcessor;

public class Histogram {

	private double[] HistogramRepresentation;	
	private double[] EqualizedHistogramRepresentation;
	private double[] ProbabilityHistogramRepresentation;
	private double[][] OriginalImage;
	private double LMin;
	private double LMax;
	
	

	public Histogram(double[][] image, double lMin, double lMax){
		this.OriginalImage = image;
		LMax = lMax;
		LMin = lMin;
		this.HistogramRepresentation = new double[(int)LMax + 1];
		this.ProbabilityHistogramRepresentation = new double[(int)LMax + 1];
		this.EqualizedHistogramRepresentation = new double[(int)LMax + 1];
		this.makeHistogram();
		
	}
		
	private void makeHistogram(){		
		try{		
		for(int i = 0 ; i< OriginalImage.length ; i++){
			for(int j = 0 ; j< OriginalImage[0].length;j++){				
				this.HistogramRepresentation[(int)OriginalImage[i][j]] += 1;
			}
		}
		
		for(int grayLevel=0;grayLevel< this.HistogramRepresentation.length ; grayLevel++){
			this.ProbabilityHistogramRepresentation[grayLevel] = this.HistogramRepresentation[grayLevel]/(OriginalImage.length * OriginalImage[0].length);
		}
		
		for(int i = ProbabilityHistogramRepresentation.length - 1 ; i >= 0 ; i--){
			for(int j = i  ; j>=0 ; j--){
				this.EqualizedHistogramRepresentation[i] += this.ProbabilityHistogramRepresentation[j];
			}
		}
		
		for(int grayLevel = 0 ; grayLevel< this.EqualizedHistogramRepresentation.length ; grayLevel++ ){
			this.EqualizedHistogramRepresentation[grayLevel] =  Math.round(this.EqualizedHistogramRepresentation[grayLevel] * (LMax)); 
		}
		}catch (Exception e) {
			
		}
	}
	
	public double[][] getEqualizedImage(){		
		double[][] imageBuffer = new double[OriginalImage.length][OriginalImage[0].length];
		for(int x = 0; x < OriginalImage.length; x++ ){
			for(int y = 0 ; y < OriginalImage[0].length; y++){
				imageBuffer[x][y] = this.EqualizedHistogramRepresentation[(int)Math.round(OriginalImage[x][y])];
			}	
		}
		return imageBuffer;
	}
	
	public double[] getHistogramRepresentation() {
		return HistogramRepresentation;
	}

	public void setHistogramRepresentation(double[] histogramRepresentation) {
		HistogramRepresentation = histogramRepresentation;
	}

	public double[] getEqualizedHistogramRepresentation() {
		return EqualizedHistogramRepresentation;
	}

	public void setEqualizedHistogramRepresentation(
			double[] equalizedHistogramRepresentation) {
		EqualizedHistogramRepresentation = equalizedHistogramRepresentation;
	}

	public double[] getProbabilityHistogramRepresentation() {
		return ProbabilityHistogramRepresentation;
	}

	public void setProbabilityHistogramRepresentation(
			double[] probabilityHistogramRepresentation) {
		ProbabilityHistogramRepresentation = probabilityHistogramRepresentation;
	}

	public double[][] getOriginalImage() {
		return OriginalImage;
	}

	public void setOriginalImage(double[][] originalImage) {
		OriginalImage = originalImage;
	}

	public double getLMin() {
		return LMin;
	}

	public void setLMin(double lMin) {
		LMin = lMin;
	}

	public double getLMax() {
		return LMax;
	}

	public void setLMax(double lMax) {
		LMax = lMax;
	}

	public double[][] getNormalizaedEqualizedHistogram(){
		return ImageProcessor.getInstance().getNormalizedImage(getEqualizedImage());
	}
		
	
}
