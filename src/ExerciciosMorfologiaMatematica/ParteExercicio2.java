package ExerciciosMorfologiaMatematica;

import GenericClass.Util;
import ProcessorPack.ImageProcessor;
import constraintsPack.IBinaryContant;

public class ParteExercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String inputPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas\\cruzes.png";
			
			String outPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\List-2e3\\Respostas\\SemCruz.png";
						
			double[][] imageSrc = Util.lerImagem(inputPath);
			
			int[][] D = new int[][]{
					{0,0,1,1,0,0,0},
					{0,0,1,1,0,0,0},
					{1,1,1,1,1,1,0},
					{1,1,1,IBinaryContant.CENTRAL,1,1,0},
					{0,0,1,1,0,0,0},
					{0,0,1,1,0,0,0},
					{0,0,0,0,0,0,0}
			};
			
			
			double[][] target = ImageProcessor.getInstance().SimplifiedHitOrMiss(imageSrc, D);
			//double[][] target = ImageProcessor.getInstance().ErosionMorfologicOperattion(imageSrc, D);
			for (int x = 0; x < target.length; x++) {
				for (int y = 0; y < target[0].length; y++) {
					if(target[x][y] == 0){
						System.out.println("( " + x +" ,"+ y +" )");
					}
				}
			}
			
			Util.salvaImagem(outPath, target);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
