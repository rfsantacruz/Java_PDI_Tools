package ListaPDI1;

import GenericClass.Util;
import ProcessorPack.ImageProcessor;

public class Exercicio5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String inputPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura4-red.jpg";
			String outPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura4redHomomorfica-red.jpg";
			
			double[][] source = Util.lerImagem(inputPath);						
			double[][] target = null;
			
			
			target = ImageProcessor.getInstance().HomomorficFrequencyFilter(source, 1, (double)8.0/128.0, 0.001,200);
			
			
			Util.salvaImagem(outPath, target);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
