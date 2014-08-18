package demos;

import GenericClass.Util;
import ProcessorPack.ImageProcessor;

public class smothSpatialFilter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String s_folderIN = "./imgs/in/";
			String s_folderOut = "./imgs/out/";
						
			String inputPath = s_folderIN + "figura3.jpg";
			
			String outPathMedia3x3 = s_folderOut + "f3Mean3x3.jpg";
			String outPathMedia5x5 = s_folderOut + "f3Mean5x5.jpg";
			String outPathMediaPonderada = s_folderOut + "f3MW.jpg";
			String outPathMediana = s_folderOut + "f3Median.jpg";
			
			
			
			double[][] source = Util.lerImagem(inputPath);						
			
			double[][] media3x3Target = ImageProcessor.getInstance().AverageSpartialFilter(1, source);
			double[][] media5x5Target = ImageProcessor.getInstance().AverageSpartialFilter(5, source);
			double[][] MediaPonderadaTarget = ImageProcessor.getInstance().WeightedAverageSpatialFilter(source);
			double[][] medianaTarget = ImageProcessor.getInstance().MedianaSpartialFilter(4, source);
			
			
			Util.salvaImagem(outPathMedia3x3, media3x3Target);
			Util.salvaImagem(outPathMedia5x5, media5x5Target);
			Util.salvaImagem(outPathMediaPonderada, MediaPonderadaTarget);
			Util.salvaImagem(outPathMediana, medianaTarget);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
