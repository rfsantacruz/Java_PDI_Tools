package ProcessorPack;
import javax.swing.text.StyleContext.SmallAttributeSet;
import javax.xml.transform.Result;

import intensityFiltersPack.GamaFilter;
import intensityFiltersPack.GrayLevelSliceFilter;
import intensityFiltersPack.IntensityFilterExecutor;
import intensityFiltersPack.Logaritmic;


import FrequencyFiltersPack.FrequencyFilterExecutor;
import FrequencyFiltersPack.HomomorficFilter;
import MoforlogicOperationsPack.DilatationMorfologicOperator;
import MoforlogicOperationsPack.ErosionMorfologicOperator;
import MoforlogicOperationsPack.HitOrMiss;
import MoforlogicOperationsPack.MorfologicOperatorExecutor;
import SetOperationsPack.ComplementOperation;
import SetOperationsPack.IntersectOperation;
import SetOperationsPack.MinusOperation;
import SetOperationsPack.SetOperationExecutor;
import SetOperationsPack.UnionSetOperation;
import SpatialFiltersPack.AverageSpatialFilter;
import SpatialFiltersPack.HarmonicAgainst;
import SpatialFiltersPack.HighBoostSpartialFilter;
import SpatialFiltersPack.HighPassSpatialFilter;
import SpatialFiltersPack.LaplacianoSpartialFilter;
import SpatialFiltersPack.MaxSpatialFilter;
import SpatialFiltersPack.MedianaAdaptativa;
import SpatialFiltersPack.MedianaSpatialFiilter;
import SpatialFiltersPack.Midpoint;
import SpatialFiltersPack.MinSpatialFilter;
import SpatialFiltersPack.SobelSpartialFilter;
import SpatialFiltersPack.SpatialFilterExecutor;
import SpatialFiltersPack.UnsharpenMaskSpartialFilter;

import constraintsPack.EFilterKey;
import constraintsPack.ESobelOperatorType;
import constraintsPack.IBinaryContant;


public class ImageProcessor {

	private volatile static ImageProcessor instance;
	
	private ImageProcessor(){		
	}
	
	public static ImageProcessor getInstance(){
		if(instance == null){
			synchronized (ImageProcessor.class) {
				if(instance == null){
					instance = new ImageProcessor();
				}
			}
		}
		return instance;
	}	
	
	public void printDoubleMatrixImage(double[][] image){
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean imageEqual(double[][] imageA, double[][] imageB){
		if(imageA.length != imageB.length || imageA[0].length != imageB[0].length)
			return false;
		
		for (int i = 0; i < imageA.length; i++) {
			for (int j = 0; j < imageA[0].length; j++) {
				if(imageA[i][j] != imageB[i][j])
					return false;
			}
		}
			
		return true;
	}
	
	
	public double[][] SimplifiedHitOrMiss(double[][] image,int[][] es) {
		IFilterExecutor op = new MorfologicOperatorExecutor();
		op.setFilter(new HitOrMiss(es));		
		return this.FromBinaryImage(op.applyFilter(this.ToBinaryImage(image)));
		
	}
	
	public double[][] FormsDetection(double[][] imageSrc, int[][] D){
		double[][] image = ToBinaryImage(imageSrc);
		
		int[][] B2 = new int[D.length + 2][D[0].length+2];
		
		for (int x = 0; x < B2.length; x++) {
			for (int y = 0; y < B2[0].length; y++) {
				B2[x][y] = IBinaryContant.ONE;
			}
		}
		
		B2[B2.length / 2 + 1][B2[0].length / 2 + 1] = IBinaryContant.CENTRAL ; 
		
		IFilterExecutor ferosion = new MorfologicOperatorExecutor();
		ferosion.setFilter(new ErosionMorfologicOperator(D));
		
		IDoubleOperandExecutor complement = new SetOperationExecutor();
		complement.setFilter(new ComplementOperation());
		
		IDoubleOperandExecutor minus = new SetOperationExecutor();
		minus.setFilter(new MinusOperation());
		
		IDoubleOperandExecutor intersect = new SetOperationExecutor();
		intersect.setFilter(new IntersectOperation());
					
		double[][] erosionAD = ferosion.applyFilter(image);
		double[][] complementA = complement.applyFilter(image, image);
		
		
		ferosion.setFilter(new ErosionMorfologicOperator(B2));
		double[][] erosionAcB2 = ferosion.applyFilter(complementA);
		
		return FromBinaryImage(intersect.applyFilter(erosionAD, erosionAcB2));
	}
	
	public double[][] RegionFilling(double[][] imageA,int[][] es, int xStart, int yStart){
		
		double[][] binaryImage = ToBinaryImage(imageA);			
		double[][] K = new double[imageA.length][imageA[0].length];
		
		IFilterExecutor dilatation = new MorfologicOperatorExecutor();
		dilatation.setFilter(new DilatationMorfologicOperator(es));
		
		IDoubleOperandExecutor complement = new SetOperationExecutor();
		complement.setFilter(new ComplementOperation());
		
		IDoubleOperandExecutor intersect = new SetOperationExecutor();
		intersect.setFilter(new IntersectOperation());
		
		IDoubleOperandExecutor union = new SetOperationExecutor();
		union.setFilter(new UnionSetOperation());
		
		double[][] complementMatrix = complement.applyFilter(binaryImage, binaryImage);
		
		K[xStart][yStart] = IBinaryContant.ONE;
						
		while(true){
			double[][] kTemp = K.clone(); 
			K = intersect.applyFilter(dilatation.applyFilter(K),complementMatrix);			
			if(imageEqual(K,kTemp))
				break;
			
		}
		
		return FromBinaryImage(union.applyFilter(K, binaryImage));
				
	}
	
	public double[][] BoundaryExtractionMorfologicOperation(double[][] imageA,int[][] es){
		IFilterExecutor op = new MorfologicOperatorExecutor();
		IDoubleOperandExecutor opd = new SetOperationExecutor();
		
		double[][]binaryImage = this.ToBinaryImage(imageA);
		
		//Erosion
		op.setFilter(new ErosionMorfologicOperator(es));
		//Minus
		opd.setFilter(new MinusOperation());
		
		return this.FromBinaryImage(opd.applyFilter(binaryImage, op.applyFilter(binaryImage)));		
	}
	
	public double[][] ClosingMorfologicOperattion(double[][] imageA,int[][] es){
		IFilterExecutor op = new MorfologicOperatorExecutor();
		
		//Dilatation
		op.setFilter(new DilatationMorfologicOperator(es));				
		double[][] temp = op.applyFilter(this.ToBinaryImage(imageA));
		
		//Erosion
		op.setFilter(new ErosionMorfologicOperator(es));
		return this.FromBinaryImage(op.applyFilter(temp));
		
	}
	
	
	public double[][] OpeningMorfologicOperattion(double[][] imageA,int[][] es){
		IFilterExecutor op = new MorfologicOperatorExecutor();
		
		//erosão
		op.setFilter(new ErosionMorfologicOperator(es));		
		double[][] temp = op.applyFilter(this.ToBinaryImage(imageA));
		
		//dilatation
		op.setFilter(new DilatationMorfologicOperator(es));
		return this.FromBinaryImage(op.applyFilter(temp));
		
	}
	
	public double[][] DilatationMorfologicOperattion(double[][] imageA,int[][] es){
		IFilterExecutor op = new MorfologicOperatorExecutor();
		op.setFilter(new DilatationMorfologicOperator(es));		
		return this.FromBinaryImage(op.applyFilter(this.ToBinaryImage(imageA)));
		
	}
	
	public double[][] ErosionMorfologicOperattion(double[][] imageA,int[][] es){
		IFilterExecutor op = new MorfologicOperatorExecutor();
		op.setFilter(new ErosionMorfologicOperator(es));		
		return this.FromBinaryImage(op.applyFilter(this.ToBinaryImage(imageA)));
		
	}
	
	
	public double[][] MinusOperattion(double[][] imageA, double[][] imageB){
		IDoubleOperandExecutor op = new SetOperationExecutor();
		op.setFilter(new MinusOperation());		
		return this.FromBinaryImage(op.applyFilter(this.ToBinaryImage(imageA),this.ToBinaryImage(imageB)));
		
	}
	
	public double[][] IntersectOperattion(double[][] imageA, double[][] imageB){
		IDoubleOperandExecutor op = new SetOperationExecutor();
		op.setFilter(new IntersectOperation());		
		return this.FromBinaryImage(op.applyFilter(this.ToBinaryImage(imageA),this.ToBinaryImage(imageB)));
		
	}
	
	public double[][] UnionOperattion(double[][] imageA, double[][] imageB){
		IDoubleOperandExecutor op = new SetOperationExecutor();
		op.setFilter(new UnionSetOperation());		
		return this.FromBinaryImage(op.applyFilter(this.ToBinaryImage(imageA),this.ToBinaryImage(imageB)));
		
	}
	public double[][] FromBinaryImage(double[][] image){
		double[][] result = new double[image.length][image[0].length];
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				result[i][j] = image[i][j] == IBinaryContant.ONE ? 00.00 : 255.00; 
			}
		}
		return result;
	}
	
	public double[][] ToBinaryImage(double[][] image){
		double[][] result = new double[image.length][image[0].length];
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				result[i][j] = image[i][j] < 128 ? IBinaryContant.ONE : IBinaryContant.ZERO; 
			}
		}
		return result;
	}
	
	public  double[][] HomomorficFrequencyFilter ( double[][] image, double c,
			double d0, double yl, double yh ){
		IFilterExecutor f = new FrequencyFilterExecutor();
		f.setFilter(new HomomorficFilter(image.length, image[0].length, c, d0, yl, yh));		
		//return this.getNormalizedImage(this.ExpIntensityFilter(this.getNormalizedImage(f.applyFilter(this.getNormalizedImage(this.Logaritmic(1, image))))));
		return this.getNormalizedImage(f.applyFilter(image));
		
	}
	
	public  double[][]  HistogramStatisticalEnhance ( double[][] image, int radius,double E,double K0 , double K1 , double K2){
		double[][] result = new double[image.length][image[0].length];
		HistogramPack.Histogram h =  this.Histogram(image, 0, 255);
		double[][] NormalizedeuqalizedHistogram = h.getNormalizaedEqualizedHistogram();		
		
		int a = radius;
		int b = radius;
		double mediaGlobal = this.MediumIntensityValue(image);
		double stdDeviationGlobal = this.ImageStandardDeviation(image);
		double mediaS = 0;
		double stdDeviationS = 0;
		
		for (int x = radius; x < image.length - radius; x++) {
			for (int y = radius; y < image[0].length - radius; y++) {											
				double sum = 0;
				for(int s = -a ; s <=a  ; s++ ){
					for(int t = -b ; t <= b ; t++){
						 mediaS += image[x+s][y+t]; 						
					}
				}											
				mediaS = mediaS /(((2.0*radius) +1)*((2.0*radius) +1));
				
				for(int s = -a ; s <=a  ; s++ ){
					for(int t = -b ; t <= b ; t++){						 
						 stdDeviationS += Math.pow(image[x+s][y+t] - mediaS,2);
						 
					}
				}
				
				stdDeviationS = Math.sqrt(stdDeviationS/(((2.0*radius) +1)*((2.0*radius) +1)));
								
				
				if(mediaS <= K0*mediaGlobal && K1*stdDeviationGlobal <= stdDeviationS && stdDeviationS <= K2*stdDeviationGlobal)
					result[x][y] = E  * image[x][y];
				else
					result[x][y] = image[x][y];
								
			}
		}
		return result;
	}
		
	public double ImageStandardDeviation(double[][] image){
		return Math.sqrt(this.ImageVariance(image));
	}
	
	public double ImageVariance(double[][] image){
		double sum = 0;
		for(int x = 0; x < image.length; x++ ){
			for(int y = 0 ; y < image[0].length; y++){
				 sum += Math.pow( image[x][y] - this.MediumIntensityValue(image),2);				 
			}	
		}
		return (sum/image.length*image[0].length);
	}
	
	public double MediumIntensityValue(double[][] image){
		double sum = 0;
		for(int x = 0; x < image.length; x++ ){
			for(int y = 0 ; y < image[0].length; y++){
				 sum += image[x][y];				 
			}	
		}
		return (sum/image.length*image[0].length);
	}
	
	public  double[][] ExpIntensityFilter( double[][] image ){
		IFilterExecutor f = new IntensityFilterExecutor();
		f.setFilter(new intensityFiltersPack.ExpIntensityFilter());
		return f.applyFilter(image);
	}
	
	public  double[][] GamaFilter(double c, double y, double[][] image ){
		IFilterExecutor f = new IntensityFilterExecutor();
		f.setFilter(new GamaFilter(c, y));
		return f.applyFilter(image);
	}
	
	public  double[][] GrayLevelSlice(double minLevel, double maxLevel , double enphasize ,boolean isToMantain ,double[][] image ){
		IFilterExecutor f = new IntensityFilterExecutor();
		f.setFilter(new GrayLevelSliceFilter(minLevel, maxLevel, enphasize, isToMantain));
		return f.applyFilter(image);
	}
	
	public  double[][] Logaritmic(double c,double[][] image){
		IFilterExecutor f = new IntensityFilterExecutor();
		f.setFilter(new Logaritmic(c));
		return f.applyFilter(image);
	}
	
	public  double[][] NegativeFilter(double maxLevel,double[][] image){
		IFilterExecutor f = new IntensityFilterExecutor();
		f.setFilter(new intensityFiltersPack.NegativeFilter(maxLevel));
		return f.applyFilter(image);
	}
	public  double[][] AverageSpartialFilter(int radius,double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new AverageSpatialFilter(radius));
		return f.applyFilter(image);
	}
	
	public  double[][] MedianaSpartialFilter(int radius,double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new MedianaSpatialFiilter(radius));
		return f.applyFilter(image);
	}
	public  double[][] MidPointSpartialFilter(int radius,double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new Midpoint(radius));
		return f.applyFilter(image);
	}
	
	public  double[][] MedianaAdaptativaSpartialFilter(int radius, int radiusMax, double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new MedianaAdaptativa(radius,radiusMax));
		return f.applyFilter(image);
	}	
	
	public double[][] GeometricMeanSpartialFilter(int radius, double[][] image){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new SpatialFiltersPack.GeometricMean(radius));
		return f.applyFilter(image);
	}
	
	public double[][] HarmonicAgainstMeanSpartialFilter(int radius, double Q,double[][] image){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new HarmonicAgainst(radius, Q));
		return this.getNormalizedImage(f.applyFilter(image));
	}
	
	public  double[][] HighBoostSpartialFilter(double  kFactor, double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new HighBoostSpartialFilter( kFactor));
		return f.applyFilter(image);
	}
	public  double[][] HighPassSpartialFilter(boolean  isDiagonalConsidered,double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new HighPassSpatialFilter(isDiagonalConsidered));
		return f.applyFilter(image);
	}
	public  double[][] LaplacianoSpartialFilter(boolean  isDiagonalConsidered, double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new LaplacianoSpartialFilter(isDiagonalConsidered));
		return f.applyFilter(image);
	}
	
	public  double[][] LaplacianoSharpeningSpartialFilter(boolean  isDiagonalConsidered, double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new LaplacianoSpartialFilter(isDiagonalConsidered));
		double[][] filteredImage =  f.applyFilter(image);
		
		double[][] result = new double[image.length][image[0].length];
		for(int x = 0 ; x<result.length ; x++){
			for(int y = 0 ; y<result[0].length ; y++){
				result[x][y] = image[x][y] + filteredImage[x][y];
			}
		}
		return this.getNormalizedImage(result);
	}
	
	public  double[][] MaxSpartialFilter(int radius,double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new MaxSpatialFilter(radius));
		return f.applyFilter(image);
	}
	
	public  double[][] MinSpartialFilter(int radius,double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new MinSpatialFilter(radius));
		return f.applyFilter(image);
	}
	public  double[][] SobelVerticalSpartialFilter(double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new SobelSpartialFilter(ESobelOperatorType.Vertical));
		return f.applyFilter(image);
	}
	
	public  double[][] SobelSpartialFilter(double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new SobelSpartialFilter(ESobelOperatorType.Vertical));
		double[][] vertical =  f.applyFilter(image);
		
		f.setFilter(new SobelSpartialFilter(ESobelOperatorType.Horizontal));
		double[][] Horizontal =  f.applyFilter(image);
		
		double[][] result = new double[image.length][image[0].length];
		for(int x = 0 ; x<result.length ; x++){
			for(int y = 0 ; y<result[0].length ; y++){
				result[x][y] = Math.abs(vertical[x][y]) + Math.abs(Horizontal[x][y]);
			}
		}
		return result;
	}
	
	public  double[][] SobelHorizontalSpartialFilter(double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new SobelSpartialFilter(ESobelOperatorType.Horizontal));
		return f.applyFilter(image);
	}
	
	public  double[][] UnSharpenSpartialFilter(int radius,double[][] image ){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new UnsharpenMaskSpartialFilter(radius));
		return f.applyFilter(image);
	}
	
	public HistogramPack.Histogram Histogram(double[][] image, double lmin, double lmax){
		HistogramPack.Histogram h = new HistogramPack.Histogram(image,lmin,lmax);
		return h;
	}
	public double[][] getNormalizedImage( double[][] OriginalImage){
		double[][] imageBuffer = new double[OriginalImage.length][OriginalImage[0].length];
		double min = Double.MAX_VALUE;		
		for(int x = 0; x < OriginalImage.length; x++ ){
			for(int y = 0 ; y < OriginalImage[0].length; y++){
				if(OriginalImage[x][y] <= min)
					min = OriginalImage[x][y];
			}	
		}
		
		for(int x = 0; x < OriginalImage.length; x++ ){
			for(int y = 0 ; y < OriginalImage[0].length; y++){
				imageBuffer[x][y] = OriginalImage[x][y] - min;
			}	
		}
		
		double max =Double.MIN_VALUE;
		for(int x = 0; x < imageBuffer.length; x++ ){
			for(int y = 0 ; y < imageBuffer[0].length; y++){
				if(imageBuffer[x][y]>= max)
					max = imageBuffer[x][y];
			}	
		}
		
		
		for(int x = 0; x < imageBuffer.length; x++ ){
			for(int y = 0 ; y < imageBuffer[0].length; y++){
				imageBuffer[x][y] = 255.00 *(imageBuffer[x][y]/max);
			}	
		}
				
		return imageBuffer;
		
	}
	
	public double[][] WeightedAverageSpatialFilter(double[][] image){
		IFilterExecutor  f = new SpatialFilterExecutor();
		f.setFilter(new SpatialFiltersPack.WeightedAverageSpatialFilter());
		return f.applyFilter(image);
	}

	
}
