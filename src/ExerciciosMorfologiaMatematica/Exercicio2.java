package ExerciciosMorfologiaMatematica;

import constraintsPack.IBinaryContant;
import GenericClass.Image;
import GenericClass.Util;
import HistogramPack.Histogram;
import ProcessorPack.ImageProcessor;

public class Exercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String inputPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas\\numero.png";
			
			String outPathErosion = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas\\numeroErosion.png";
			String outPathDilatation = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas\\numeroDilatation.png";
			String outPathOpening = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas\\numeroOpening.png";
			String outPathClosing = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas\\numeroClosing.png";
			String outPathBondaryExtraction = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas\\numeroBondaryEx.png";
			
			double[][] imageA = Util.lerImagem(inputPath);
			
			int[][] element = new int[][]{
					{IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE},
					{IBinaryContant.ONE,IBinaryContant.CENTRAL,IBinaryContant.ONE},
					{IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE}					
			};
			
			double[][] targetErosion = ImageProcessor.getInstance().ErosionMorfologicOperattion(imageA, element);
			double[][] targetDilatation = ImageProcessor.getInstance().DilatationMorfologicOperattion(imageA, element);
			double[][] targetOpening = ImageProcessor.getInstance().OpeningMorfologicOperattion(imageA, element);
			double[][] targetClosing = ImageProcessor.getInstance().ClosingMorfologicOperattion(imageA, element);			
			double[][] targetBoundaryex = ImageProcessor.getInstance().BoundaryExtractionMorfologicOperation(imageA, element);
			
			Util.salvaImagem(outPathErosion, targetErosion);
			Util.salvaImagem(outPathDilatation, targetDilatation);
			Util.salvaImagem(outPathOpening, targetOpening);
			Util.salvaImagem(outPathClosing, targetClosing);
			Util.salvaImagem(outPathBondaryExtraction, targetBoundaryex);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
