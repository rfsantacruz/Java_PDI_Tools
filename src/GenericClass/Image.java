package GenericClass;

public class Image {

	private double Lmax;
	private double Lmin;
	private int XSize;
	private int YSize;
	private String Path;
	private double[][] pixelMatrix;
	
	public Image(String caminho) throws Exception{
		 this.Path = caminho;
		 this.pixelMatrix =  Util.lerImagem(caminho);
		XSize = pixelMatrix.length;
		YSize = pixelMatrix[0].length;
		double maxLevel = Double.MIN_VALUE;
		double minLevel = Double.MAX_VALUE;
		
		for(int x = 0 ; x < XSize ;x++){
			for(int y = 0 ; y< YSize ; y++){
				
				if(pixelMatrix[x][y] >= maxLevel)
					maxLevel = pixelMatrix[x][y];
				
				if(pixelMatrix[x][y] <= minLevel )
					minLevel = pixelMatrix[x][y];
			}
		}
		
		this.Lmax = maxLevel;
		this.Lmin = minLevel;
	}
	
	public Image(double lmax, double lmin, int xSize, int ySize,
			String caminho) {
		super();
		Lmax = lmax;
		Lmin = lmin;
		XSize = xSize;
		YSize = ySize;
		Path = caminho;
	}
	public Image(double[][] bufferImage, double lmax, double lmin) {		
		Lmax = lmax;
		Lmin = lmin;
		XSize = bufferImage.length;
		YSize = bufferImage[0].length;
		this.pixelMatrix = bufferImage;
	}
	
	public double pixelQuantity(){
		return (this.getXSize()*this.getYSize());
	}
	
	public double imageMediumIntensityValue(){
		double sum = 0;
		for(int x = 0; x < this.getXSize(); x++ ){
			for(int y = 0 ; y < this.getYSize(); y++){
				 sum += this.pixelMatrix[x][y];				 
			}	
		}
		return (sum/this.pixelQuantity());
	}
	
	public double imageVariance(){
		double sum = 0;
		for(int x = 0; x < this.getXSize(); x++ ){
			for(int y = 0 ; y < this.getYSize(); y++){
				 sum += Math.pow( this.pixelMatrix[x][y] - this.imageMediumIntensityValue(),2);				 
			}	
		}
		return (sum/this.pixelQuantity());
	}
	
	public double imageStandardDeviation(){
		return Math.sqrt(this.imageVariance());
	}
	
	public void WriteImage(String outPutPath) throws Exception{
		Util.salvaImagem(outPutPath, pixelMatrix);
	}
	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public double[][] getPixelMatrix() {
		return pixelMatrix;
	}

	public void setPixelMatrix(double[][] pixelMatrix) {
		this.pixelMatrix = pixelMatrix;
	}

	public String getCaminho() {
		return Path;
	}
	public void setCaminho(String caminho) {
		Path = caminho;
	}
	public double getLmax() {
		return Lmax;
	}
	public void setLmax(double lmax) {
		Lmax = lmax;
	}
	public double getLmin() {
		return Lmin;
	}
	public void setLmin(double lmin) {
		Lmin = lmin;
	}
	public int getXSize() {
		return XSize;
	}
	public void setXSize(int xSize) {
		XSize = xSize;
	}
	public int getYSize() {
		return YSize;
	}
	public void setYSize(int ySize) {
		YSize = ySize;
	}
	
}
