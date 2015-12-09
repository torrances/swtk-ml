package org.swtk.ml.w2v.dto.adapter;

import org.swtk.ml.w2v.dto.Word2VecContract;

public final class Word2VecContractAdapter {

	public static Word2VecContract trainingExample1() {

		/*	parameter values from
		 * 	<http://deeplearning4j.org/word2vec.html#just>	*/
		return trainingExample1(1000, 300, 30);
	}

	public static Word2VecContract trainingExample1(Integer batchSize, Integer layerSize, Integer iterations) {
		
		/*	parameter values from
		 * 	<http://deeplearning4j.org/word2vec.html#just>	*/
		return transform(batchSize, 1e-5, 5, layerSize, iterations, 0.025, 1e-2, 10, 100, 42, 5);
	}

	public static Word2VecContract trainingExample2() {
		
		/*	parameter values from
		 * 	<http://deeplearning4j.org/word2vec.html#just>	*/
		return trainingExample1(1000, 100, 1);
	}

	public static Word2VecContract transform(Integer batchSize, Double sampling, Integer minWordFrequency, Integer layerSize, Integer iterations, double learningRate, double minLearningRate, Integer negativeSample, Integer vectorLength, Integer seed, Integer windowSize) {
		Word2VecContract contract = new Word2VecContract();

		contract.setBatchSize(batchSize);
		contract.setSampling(sampling);
		contract.setMinWordFrequency(minWordFrequency);
		contract.setLayerSize(layerSize);
		contract.setIterations(iterations);
		contract.setLearningRate(learningRate);
		contract.setMinLearningRate(minLearningRate);
		contract.setNegativeSample(negativeSample);
		contract.setVectorLength(vectorLength);
		contract.setSeed(seed);
		contract.setWindowSize(windowSize);

		return contract;
	}
}
