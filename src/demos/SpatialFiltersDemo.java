package demos;

import GenericClass.Util;
import ProcessorPack.ImageProcessor;

public class SpatialFiltersDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			String s_folderIN = "./imgs/in/";
			String s_folderOut = "./imgs/out/";
			
			String inputPath = s_folderIN + "figura2.jpg";
			
			String outPathLaplacianaNormalizada = s_folderOut + "f2LaplacianaNormalizada.jpg";
			String outPathSobelGradiente = s_folderOut + "f2SobelGradiente.jpg";
			
			double[][] source = Util.lerImagem(inputPath);						

			double[][] laplacianoNomalizadaTarget = ImageProcessor.getInstance().getNormalizedImage(ImageProcessor.getInstance().LaplacianoSpartialFilter(true,source));
			double[][] LaplacianaSharpeningTarget = ImageProcessor.getInstance().LaplacianoSharpeningSpartialFilter(true,source );
			double[][] SobelGradienteTarget = ImageProcessor.getInstance().getNormalizedImage(ImageProcessor.getInstance().SobelSpartialFilter(source));
			
			
			Util.salvaImagem(outPathLaplacianaNormalizada, laplacianoNomalizadaTarget);
			Util.salvaImagem(outPathSobelGradiente, SobelGradienteTarget);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
