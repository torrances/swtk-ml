package org.swtk.ml.w2v.svc;

import org.swtk.ml.w2v.dmo.CreateVectorSpace;
import org.swtk.ml.w2v.dto.FileContract;
import org.swtk.ml.w2v.dto.Word2VecContract;

public class W2vRunner {

	public static void main(String... args) throws Throwable {

		FileContract fileContract = new FileContract();
		fileContract.setInputFile("/Users/craigtrim/Desktop/word2vec/ccr/dat/ccr004.dat");
		fileContract.setOutputFile("/Users/craigtrim/Desktop/temp.vec");

		Word2VecContract w2vContract = new Word2VecContract();

		w2vContract.setBatchSize(1000);
		w2vContract.setSampling(1e-5);
		w2vContract.setMinWordFrequency(5);
		w2vContract.setLayerSize(300);
		w2vContract.setIterations(30);
		w2vContract.setLearningRate(0.025);
		w2vContract.setMinLearningRate(1e-2);
		w2vContract.setNegativeSample(10);
		w2vContract.setVectorLength(100);

		new CreateVectorSpace().process(fileContract, w2vContract);
	}
}
