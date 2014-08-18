package ExerciciosMorfologiaMatematica;

import GenericClass.Util;
import ProcessorPack.ImageProcessor;
import constraintsPack.IBinaryContant;

public class Exercicio3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			String inputPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas\\tracos.png";
			
			String outPathErosion = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas\\tracosErosion.png";
			String outPathErosionDilatation = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas\\tracosErosionDilatation.png";
			
			double[][] imageA = Util.lerImagem(inputPath);
			
			int[][] element = new int[][]{
					{IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE},
					{IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE},
					{IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.CENTRAL,IBinaryContant.ONE,IBinaryContant.ONE},
					{IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE},
					{IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE}
			};
			
			double[][] targetErosion = ImageProcessor.getInstance().ErosionMorfologicOperattion(imageA, element);
			Util.salvaImagem(outPathErosion, targetErosion);
			
			
			double[][] targetDilatation = ImageProcessor.getInstance().DilatationMorfologicOperattion(targetErosion, element);
			Util.salvaImagem(outPathErosionDilatation, targetDilatation);
						
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
