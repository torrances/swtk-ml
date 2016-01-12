package org.swtk.dl4j.w2v.generic.dto;

public class Word2VecContract {

	private Integer batchSize;

	private Double sampling;

	private Integer iterations;

	private Double minLearningRate;

	private Integer negativeSample;

	private Integer layerSize;

	private Double learningRate;

	private Integer vectorLength;

	private Integer minWordFrequency;

	private Integer seed;

	private Integer windowSize;

	public Integer getBatchSize() {
		return batchSize;
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

	public Double getMinLearningRate() {
		return minLearningRate;
	}

	public Integer getMinWordFrequency() {
		return minWordFrequency;
	}

	public Integer getNegativeSample() {
		return negativeSample;
	}

	public Double getSampling() {
		return sampling;
	}

	public Integer getSeed() {
		return seed;
	}

	public Integer getVectorLength() {
		return vectorLength;
	}

	public Integer getWindowSize() {
		return windowSize;
	}

	public void setBatchSize(Integer batchSize) {
		this.batchSize = batchSize;
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

	public void setMinLearningRate(Double minLearningRate) {
		this.minLearningRate = minLearningRate;
	}

	public void setMinWordFrequency(Integer minWordFrequency) {
		this.minWordFrequency = minWordFrequency;
	}

	public void setNegativeSample(Integer negativeSample) {
		this.negativeSample = negativeSample;
	}

	public void setSampling(Double sampling) {
		this.sampling = sampling;
	}

	public void setSeed(Integer seed) {
		this.seed = seed;
	}

	public void setVectorLength(Integer vectorLength) {
		this.vectorLength = vectorLength;
	}

	public void setWindowSize(Integer windowSize) {
		this.windowSize = windowSize;
	}
}
