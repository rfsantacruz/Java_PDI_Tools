package ListaPDI1;

import GenericClass.Image;
import GenericClass.Util;
import HistogramPack.Histogram;
import ProcessorPack.ImageProcessor;
import SpatialFiltersPack.LaplacianoSpartialFilter;

public class Exercicio3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String inputPath = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura2.jpg";
			
			String outPathLaplaciana = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura2Laplaciana.jpg";
			String outPathLaplacianaNormalizada = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura2LaplacianaNormalizada.jpg";
			String outPathLaplacianaSharpening = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura2LaplacianaSharpening.jpg";
			
			String outPathSobelVertical = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura2SobelVertical.jpg";
			String outPathSobelHorizontal = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura2SobelHorizontal.jpg";
			String outPathSobelGradiente = "C:\\Users\\Rodrigo Santa Cruz\\Documents\\My Dropbox\\UPE\\8º periodo\\PDI\\lista-1\\Respostas1\\figura2SobelGradiente.jpg";
			
			double[][] source = Util.lerImagem(inputPath);						
			
			double[][] laplacianoTarget = ImageProcessor.getInstance().LaplacianoSpartialFilter(true,source);
			double[][] laplacianoNomalizadaTarget = ImageProcessor.getInstance().getNormalizedImage(ImageProcessor.getInstance().LaplacianoSpartialFilter(true,source));
			double[][] LaplacianaSharpeningTarget = ImageProcessor.getInstance().LaplacianoSharpeningSpartialFilter(true,source );
			double[][] SobelVerticalTarget = ImageProcessor.getInstance().getNormalizedImage(ImageProcessor.getInstance().SobelVerticalSpartialFilter(source));
			double[][] SobelHorizontalTarget = ImageProcessor.getInstance().getNormalizedImage(ImageProcessor.getInstance().SobelHorizontalSpartialFilter(source));
			double[][] SobelGradienteTarget = ImageProcessor.getInstance().getNormalizedImage(ImageProcessor.getInstance().SobelSpartialFilter(source));
			
			
			Util.salvaImagem(outPathLaplaciana, laplacianoTarget);
			Util.salvaImagem(outPathLaplacianaNormalizada, laplacianoNomalizadaTarget);
			Util.salvaImagem(outPathLaplacianaSharpening, LaplacianaSharpeningTarget);
			Util.salvaImagem(outPathSobelVertical, SobelVerticalTarget);
			Util.salvaImagem(outPathSobelHorizontal, SobelHorizontalTarget);
			Util.salvaImagem(outPathSobelGradiente, SobelGradienteTarget);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
