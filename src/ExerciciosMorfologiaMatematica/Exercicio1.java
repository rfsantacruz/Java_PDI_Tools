package ExerciciosMorfologiaMatematica;

import ProcessorPack.ImageProcessor;

public class Exercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[][] imageA = new double[][]{
				{0,0,0,0,0,0},
				{0,200,200,200,0,0},
				{0,204,206,200,0,0},
				{0,205,200,200,0,0},
				{0,200,200,200,0,0},
				{0,0,0,0,0,0}
		} ;
		double[][] imageB = new double[][]{
				{0,0,0,200,200,0},
				{0,0,0,200,200,0},
				{0,0,0,200,200,0},
				{0,0,0,200,200,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0}
		} ;
		
		double[][] resultUnion = ImageProcessor.getInstance().UnionOperattion(imageA, imageB);
		double[][] resultIntersect = ImageProcessor.getInstance().IntersectOperattion(imageA, imageB);
		double[][] resultMinus = ImageProcessor.getInstance().MinusOperattion(imageA, imageB);

		System.out.println("Image A");
		ImageProcessor.getInstance().printDoubleMatrixImage(ImageProcessor.getInstance().ToBinaryImage(imageA));
		System.out.println("Image B");
		ImageProcessor.getInstance().printDoubleMatrixImage(ImageProcessor.getInstance().ToBinaryImage(imageB));
		
		System.out.println("Union:");
		ImageProcessor.getInstance().printDoubleMatrixImage(ImageProcessor.getInstance().ToBinaryImage(resultUnion));
		System.out.println("Intersect:");
		ImageProcessor.getInstance().printDoubleMatrixImage(ImageProcessor.getInstance().ToBinaryImage(resultIntersect));
		System.out.println("Minus:");
		ImageProcessor.getInstance().printDoubleMatrixImage(ImageProcessor.getInstance().ToBinaryImage(resultMinus));
		
	}

}
