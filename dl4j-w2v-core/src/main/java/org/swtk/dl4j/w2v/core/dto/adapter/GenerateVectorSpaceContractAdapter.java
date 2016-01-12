package org.swtk.dl4j.w2v.core.dto.adapter;

import java.io.File;

import org.swtk.dl4j.w2v.core.dto.GenerateVectorSpaceContract;
import org.swtk.dl4j.w2v.core.utils.Constants;

import com.trimc.blogger.commons.exception.AdapterValidationException;
import com.trimc.blogger.commons.utils.file.FileUtils;

public final class GenerateVectorSpaceContractAdapter {

	public static GenerateVectorSpaceContract transform(File inputFile, File outputDirectoryForWord2VecIndex) throws AdapterValidationException {
		GenerateVectorSpaceContract contract = new GenerateVectorSpaceContract();

		contract.setInputFile(inputFile);
		contract.setOutputDirectoryForWord2VecIndex(outputDirectoryForWord2VecIndex);

		return contract;
	}

	public static GenerateVectorSpaceContract transform(String inputFilePath) throws AdapterValidationException {

		File inputFile = new File(inputFilePath);
		if (!inputFile.exists()) throw new AdapterValidationException("Input Path does not exist (path = %s)", inputFilePath);

		File outputDirectoryForWord2VecIndex = new File(Constants.OUTPUT_DIRECTORY + "dr-who");
		if (outputDirectoryForWord2VecIndex.exists()) FileUtils.delete(outputDirectoryForWord2VecIndex);
		if (!outputDirectoryForWord2VecIndex.exists()) outputDirectoryForWord2VecIndex.mkdirs();

		return transform(inputFile, outputDirectoryForWord2VecIndex);
	}
}
