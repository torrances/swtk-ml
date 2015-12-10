package org.swtk.ml.w2v.gnv;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.swtk.ml.w2v.core.utils.VectorUtils;

public class UseGoogleVectorSpace {

	public static void main(String... args) throws Throwable {

		File gModel = new File("/Users/craigtrim/Downloads/GoogleNews-vectors-negative300.bin.gz");
		Word2Vec vec = WordVectorSerializer.loadGoogleModel(gModel, true);

		Collection<String> kingList = vec.wordsNearest(Arrays.asList("king", "woman"), Arrays.asList("queen"), 10);
		for (String k : kingList)
			System.err.println(k);

		//INDArray wordVector = vec.getWordVectorMatrix("king");
		double[] wv = vec.getWordVector("king");
		
		StringBuilder sb = new StringBuilder();
		for (double d : wv) sb.append(d + " ");
		System.err.println(sb.toString().trim());
		
		System.err.println(VectorUtils.toString(vec.wordsNearest("dalek", 10)));
		System.err.println(vec.similarity("day", "night"));
		System.err.println(vec.similarity("sweden", "norway"));
		
		VectorUtils.nearest(vec, "dalek", 10);
	}
}
