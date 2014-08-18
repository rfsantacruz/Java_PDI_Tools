package List2;

import GenericClass.Util;
import ProcessorPack.ImageProcessor;

public class Exercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			
			String inputPathF1 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\F1.png";
			String inputPathF2 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\F2.png";
			String inputPathF3 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\F3.png";
			
			
			String outPathCH15F1 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\CH15F1.png";
			String outPathCH15F2 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\CH15F2.png";
			String outPathCH15F3 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\CH15F3.png";
			
			String outPathCHn15F1 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\CH15negF1.png";
			String outPathCHn15F2 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\CH15negF2.png";
			String outPathCHn15F3 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\CH15negF3.png";
			
			String outPathMedianaF1 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\MedianaF1.png";
			String outPathMedianaF2 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\MedianaF2.png";
			String outPathMedianaF3 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\MedianaF3.png";
			
			String outPathMedianaAdaptativaF1 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\MedianaAdaptativaF1.png";
			String outPathMedianaAdaptativaF2 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\MedianaAdaptativaF2.png";
			String outPathMedianaAdaptativaF3 = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas_Lista2\\EXE_2\\MedianaAdaptativaF3.png";
						
			
			double[][] imageF1 = Util.lerImagem(inputPathF1);
			double[][] imageF2 = Util.lerImagem(inputPathF2);
			double[][] imageF3 = Util.lerImagem(inputPathF3);
			
			
			
			double[][] targetCH15F1 = ImageProcessor.getInstance().HarmonicAgainstMeanSpartialFilter(1, 1.5, imageF1);
			double[][] targetCH15F2 = ImageProcessor.getInstance().HarmonicAgainstMeanSpartialFilter(1, 1.5, imageF2);
			double[][] targetCH15F3 = ImageProcessor.getInstance().HarmonicAgainstMeanSpartialFilter(1, 1.5, imageF3);
			
			double[][] targetCHn15F1 = ImageProcessor.getInstance().HarmonicAgainstMeanSpartialFilter(1, -1.5, imageF1);
			double[][] targetCHn15F2 = ImageProcessor.getInstance().HarmonicAgainstMeanSpartialFilter(1, -1.5, imageF2);
			double[][] targetCHn15F3 = ImageProcessor.getInstance().HarmonicAgainstMeanSpartialFilter(1, -1.5, imageF3);
			
			double[][] targetMedianaF1 = ImageProcessor.getInstance().MedianaSpartialFilter(2, imageF1);
			double[][] targetMedianaF2 = ImageProcessor.getInstance().MedianaSpartialFilter(2, imageF2);
			double[][] targetMedianaF3 = ImageProcessor.getInstance().MedianaSpartialFilter(2, imageF3);
			
			double[][] targetMedianaAdaptativaF1 = ImageProcessor.getInstance().MedianaAdaptativaSpartialFilter(1, 5, imageF1);
			double[][] targetMedianaAdaptativaF2 = ImageProcessor.getInstance().MedianaAdaptativaSpartialFilter(1, 5, imageF2);
			double[][] targetMedianaAdaptativaF3 = ImageProcessor.getInstance().MedianaAdaptativaSpartialFilter(1, 5, imageF3);
			
			Util.salvaImagem(outPathCH15F1, targetCH15F1);
			Util.salvaImagem(outPathCH15F2, targetCH15F2);
			Util.salvaImagem(outPathCH15F3, targetCH15F3);
			
			Util.salvaImagem(outPathCHn15F1, targetCHn15F1);
			Util.salvaImagem(outPathCHn15F2, targetCHn15F2);
			Util.salvaImagem(outPathCHn15F3, targetCHn15F3);
			
			Util.salvaImagem(outPathMedianaF1, targetMedianaF1);
			Util.salvaImagem(outPathMedianaF2, targetMedianaF2);
			Util.salvaImagem(outPathMedianaF3, targetMedianaF3);
			
			Util.salvaImagem(outPathMedianaAdaptativaF1, targetMedianaAdaptativaF1);
			Util.salvaImagem(outPathMedianaAdaptativaF2, targetMedianaAdaptativaF2);
			Util.salvaImagem(outPathMedianaAdaptativaF3, targetMedianaAdaptativaF3);
		
		}catch (Exception e) {
			e.printStackTrace();
		}


	}

}
