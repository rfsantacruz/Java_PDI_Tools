package ExerciciosMorfologiaMatematica;

import java.util.Iterator;

import GenericClass.Util;
import ProcessorPack.ImageProcessor;
import constraintsPack.IBinaryContant;

public class Parte2Exercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		try{
			String inputPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas\\poligono.png";
			
			String outPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas\\poligonoPrenchido.png";
						
			double[][] imageA = Util.lerImagem(inputPath);
			
			int[][] element = new int[][]{
					{IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE},
					{IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE},
					{IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.CENTRAL,IBinaryContant.ONE,IBinaryContant.ONE},
					{IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE},
					{IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE,IBinaryContant.ONE}
			};
			
			
			double[][] target = ImageProcessor.getInstance().RegionFilling(imageA, element, 70, 100);
			double[][] targetFinal = ImageProcessor.getInstance().RegionFilling(target, element, 130, 30);
			Util.salvaImagem(outPath, targetFinal);
					
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
