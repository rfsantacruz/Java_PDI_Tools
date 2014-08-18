package demos;

import GenericClass.Image;
import GenericClass.Util;
import HistogramPack.Histogram;
import ProcessorPack.ImageProcessor;

public class HistogramEquDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s_folderIN = "./imgs/in/";
		String s_folderOut = "./imgs/out/";
		
		String inputPath =  s_folderIN + "figura1.jpg";
		String outPathNormalizedEqualized = s_folderOut + "f1_EqNorm.jpg";
		
		try {
		
			//read image			
			Image source =  new Image(inputPath);
			
			//gradient equalization
			Histogram h = ImageProcessor.getInstance().Histogram(source.getPixelMatrix(), source.getLmin(), source.getLmax());			
			Image targetNormalized = new Image(h.getNormalizaedEqualizedHistogram(),255,0);
			
			
			//save image
			targetNormalized.WriteImage(outPathNormalizedEqualized);			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
