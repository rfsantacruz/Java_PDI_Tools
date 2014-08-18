package List2;

import constraintsPack.IBinaryContant;
import GenericClass.Util;
import ProcessorPack.ImageProcessor;

public class Exercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String inputPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\fonte.png";
			
			//a
			String outPathMediaArit3x3 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\MediaArit3x3.png";
			String outPathMediaArit7x7 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\MediaArit7x7.png";
			String outPathMediaArit9x9 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\MediaArit9x9.png";
			
			//b
			String outPathGeometric3x3 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\Geometric3x3.png";
			String outPathGeometric7x7 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\Geometric7x7.png";
			String outPathGeometric9x9 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\Geometric9x9.png";
			
			//c
			String outPathMediana3x3 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\Mediana3x3.png";
			String outPathMediana7x7 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\Mediana7x7.png";
			String outPathMediana9x9 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\Mediana9x9.png";
			
			//d
			String outPathMidpoint3x3 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\Midpoint3x3.png";
			String outPathMidpoint7x7 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\Midpoint7x7.png";
			String outPathMidpoint9x9 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\Midpoint9x9.png";
			
			double[][] imageA = Util.lerImagem(inputPath);
			
			
			
			double[][] targetMediaArit3x3 = ImageProcessor.getInstance().AverageSpartialFilter(1, imageA);
			double[][] targetMediaArit7x7 = ImageProcessor.getInstance().AverageSpartialFilter(3, imageA);
			double[][] targetMediaArit9x9 = ImageProcessor.getInstance().AverageSpartialFilter(4, imageA);
			
			double[][] targetGeometric3x3 = ImageProcessor.getInstance().GeometricMeanSpartialFilter(1, imageA);
			double[][] targetGeometric7x7 = ImageProcessor.getInstance().GeometricMeanSpartialFilter(3, imageA);
			double[][] targetGeometric9x9 = ImageProcessor.getInstance().GeometricMeanSpartialFilter(4, imageA);
			
			double[][] targetMediana3x3 = ImageProcessor.getInstance().MedianaSpartialFilter(1, imageA);
			double[][] targetMediana7x7 = ImageProcessor.getInstance().MedianaSpartialFilter(3, imageA);
			double[][] targetMediana9x9 = ImageProcessor.getInstance().MedianaSpartialFilter(4, imageA);
			
			double[][] targetMidpoint3x3 = ImageProcessor.getInstance().MidPointSpartialFilter(1, imageA);
			double[][] targetMidpoint7x7 = ImageProcessor.getInstance().MidPointSpartialFilter(3, imageA);
			double[][] targetMidpoint9x9 = ImageProcessor.getInstance().MidPointSpartialFilter(4, imageA);
			
			Util.salvaImagem(outPathMediaArit3x3, targetMediaArit3x3);
			Util.salvaImagem(outPathMediaArit7x7, targetMediaArit7x7);
			Util.salvaImagem(outPathMediaArit9x9, targetMediaArit9x9);
			
			Util.salvaImagem(outPathGeometric3x3, targetGeometric3x3);
			Util.salvaImagem(outPathGeometric7x7, targetGeometric7x7);
			Util.salvaImagem(outPathGeometric9x9, targetGeometric9x9);
			
			Util.salvaImagem(outPathMediana3x3, targetMediana3x3);
			Util.salvaImagem(outPathMediana7x7, targetMediana7x7);
			Util.salvaImagem(outPathMediana9x9, targetMediana9x9);
			
			Util.salvaImagem(outPathMidpoint3x3, targetMidpoint3x3);
			Util.salvaImagem(outPathMidpoint7x7, targetMidpoint7x7);
			Util.salvaImagem(outPathMidpoint9x9, targetMidpoint9x9);
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
