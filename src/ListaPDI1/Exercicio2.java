package ListaPDI1;

import GenericClass.Image;
import GenericClass.Util;
import HistogramPack.Histogram;
import ProcessorPack.ImageProcessor;

public class Exercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String inputPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura1.jpg";
			String outPathEqualized = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura1Equalizada.jpg";
			String outPathNormalizedEqualized = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura1EqualizadaNormalizada.jpg";
			String outPathEstatisticaLocal = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura1Estatisticalocal.jpg";
			
			Image source =  new Image(inputPath);						
			
			Histogram h = ImageProcessor.getInstance().Histogram(source.getPixelMatrix(), source.getLmin(), source.getLmax());
			
			Image targetEqualized = new Image(h.getEqualizedImage(),255,0);
			Image targetNormalized = new Image(h.getNormalizaedEqualizedHistogram(),255,0);
			double[][] targetEstatisticaLocal = ImageProcessor.getInstance().HistogramStatisticalEnhance(source.getPixelMatrix(), 1, 5, 0.000005, 0.00000000001 , 0.8);
			
			targetEqualized.WriteImage(outPathEqualized);
			targetNormalized.WriteImage(outPathNormalizedEqualized);
			
			Util.salvaImagem(outPathEstatisticaLocal, targetEstatisticaLocal);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
