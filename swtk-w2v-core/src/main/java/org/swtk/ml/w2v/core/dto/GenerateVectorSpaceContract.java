package org.swtk.ml.w2v.core.dto;

import java.io.File;

public class GenerateVectorSpaceContract {

	private File inputFile;
	
	private File outputDirectoryForWord2VecIndex;

	public File getInputFile() {
		return inputFile;
	}

	public File getOutputDirectoryForWord2VecIndex() {
		return outputDirectoryForWord2VecIndex;
	}

	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}

	public void setOutputDirectoryForWord2VecIndex(File outputDirectoryForWord2VecIndex) {
		this.outputDirectoryForWord2VecIndex = outputDirectoryForWord2VecIndex;
	}
}
