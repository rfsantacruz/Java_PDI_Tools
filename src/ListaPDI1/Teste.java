package ListaPDI1;

import GenericClass.Util;
import ProcessorPack.ImageProcessor;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String inputPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura4-red.jpg";
			String outPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura4red.jpg";
			
			double[][] source = Util.lerImagem(inputPath);						
			
			
			//double[][] target = ImageProcessor.getInstance().ExpIntensityFilter(source);
			
			double[][] target = ImageProcessor.getInstance().HomomorficFrequencyFilter(source, 1, 8/128.0, 0.7, 1.3);
			
			Util.salvaImagem(outPath, target);
		
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
