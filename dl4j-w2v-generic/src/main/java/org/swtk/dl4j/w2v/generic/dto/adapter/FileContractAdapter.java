package org.swtk.dl4j.w2v.generic.dto.adapter;

import org.swtk.dl4j.w2v.generic.dto.FileContract;

public final class FileContractAdapter {

	public static FileContract transform(String inputFile, String outputFile, Integer batchSize, Integer iterations, Integer layerSize, double learningRate, Integer seed, Integer windowSize) {
		FileContract contract = new FileContract();

		contract.setInputFile(inputFile);
		contract.setOutputFile(outputFile);

		return contract;
	}
}
