package ListaPDI1;

import GenericClass.Util;
import ProcessorPack.ImageProcessor;

public class Exercicio4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String inputPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura3.jpg";
			
			String outPathMedia3x3 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura3Media3x3.jpg";
			String outPathMedia5x5 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura3Media5x5.jpg";
			String outPathMediaPonderada = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura3MediaPonderada.jpg";
			String outPathMediana = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura3Mediana.jpg";
			String outPathMin3X3 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura3Min3x3.jpg";
			String outPathMax3X3 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura3Max3x3.jpg";
			
			
			double[][] source = Util.lerImagem(inputPath);						
			
			double[][] media3x3Target = ImageProcessor.getInstance().AverageSpartialFilter(1, source);
			double[][] media5x5Target = ImageProcessor.getInstance().AverageSpartialFilter(5, source);
			double[][] MediaPonderadaTarget = ImageProcessor.getInstance().WeightedAverageSpatialFilter(source);
			double[][] medianaTarget = ImageProcessor.getInstance().MedianaSpartialFilter(4, source);
			double[][] min3x3Target = ImageProcessor.getInstance().MinSpartialFilter(1, source);
			double[][] max3x3Target = ImageProcessor.getInstance().MaxSpartialFilter(1, source);
			
			
			
			Util.salvaImagem(outPathMedia3x3, media3x3Target);
			Util.salvaImagem(outPathMedia5x5, media5x5Target);
			Util.salvaImagem(outPathMediaPonderada, MediaPonderadaTarget);
			Util.salvaImagem(outPathMediana, medianaTarget);
			Util.salvaImagem(outPathMin3X3, min3x3Target);
			Util.salvaImagem(outPathMax3X3, max3x3Target);		
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
