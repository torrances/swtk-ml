package word2vec.dto;

public class Contract {
	
	private Integer batchSize;
	
	private String inputFile;

	private Integer iterations;

	private Integer layerSize;

	private Double learningRate;

	private String outputFile;

	private Integer seed;
	
	private Integer windowSize;
	
	public Integer getBatchSize() {
		return batchSize;
	}
	
	public String getInputFile() {
		return inputFile;
	}

	public Integer getIterations() {
		return iterations;
	}

	public Integer getLayerSize() {
		return layerSize;
	}
	
	public Double getLearningRate() {
		return learningRate;
	}
	
	public String getOutputFile() {
		return outputFile;
	}

	public Integer getSeed() {
		return seed;
	}

	public Integer getWindowSize() {
		return windowSize;
	}

	public void setBatchSize(Integer batchSize) {
		this.batchSize = batchSize;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public void setIterations(Integer iterations) {
		this.iterations = iterations;
	}

	public void setLayerSize(Integer layerSize) {
		this.layerSize = layerSize;
	}

	public void setLearningRate(Double learningRate) {
		this.learningRate = learningRate;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public void setSeed(Integer seed) {
		this.seed = seed;
	}

	public void setWindowSize(Integer windowSize) {
		this.windowSize = windowSize;
	}
}
