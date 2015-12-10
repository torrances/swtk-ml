package org.swtk.ml.w2v.drwho.svc;

import java.io.File;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;
import org.swtk.ml.w2v.core.utils.VectorUtils;

public class UseVectorSpaceDrWho2 {

	public static void main(String... args) throws Throwable {

		WordVectors vec = WordVectorSerializer.loadTxtVectors(new File("/Users/craigtrim/Desktop/drwho/vec/drwho005.vec"));

		VectorUtils.nearest(vec, "skaro", 10);
		VectorUtils.s(vec, "skaro", "dalek");

	}
}
