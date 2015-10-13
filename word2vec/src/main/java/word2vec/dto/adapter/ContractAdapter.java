package word2vec.dto.adapter;

import java.io.File;

import word2vec.dto.Contract;

public final class ContractAdapter {

	public static Contract transform(String... args) throws Exception {

		if (args.length < 2) {
			StringBuilder sb = new StringBuilder();
			sb.append("\n\t1. Input File Path");
			sb.append("\n\t2. Output File Path");
			throw new Exception("The following parameters are expected:" + sb.toString());
		}

		String inputFile = args[0];
		if (!new File(inputFile).exists()) throw new Exception(String.format("Input File does not exist (path = %s)", inputFile));
		String outputFile = args[1];

		return transform(inputFile, outputFile, 1000, 50, 300, 0.025d, 42, 5);
	}

	public static Contract transform(String inputFile, String outputFile, Integer batchSize, Integer iterations, Integer layerSize, double learningRate, Integer seed, Integer windowSize) {
		Contract contract = new Contract();

		contract.setInputFile(inputFile);
		contract.setOutputFile(outputFile);
		contract.setBatchSize(batchSize);
		contract.setIterations(iterations);
		contract.setLayerSize(layerSize);
		contract.setLearningRate(learningRate);
		contract.setSeed(seed);
		contract.setWindowSize(windowSize);

		return contract;
	}
}
