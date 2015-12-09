package word2vec;

import java.io.File;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;

import word2vec.util.VectorUtils;

public class UseVectorSpaceDrWho2 {

	public static void main(String... args) throws Throwable {

		WordVectors vec = WordVectorSerializer.loadTxtVectors(new File("/Users/craigtrim/Desktop/drwho/vec/drwho005.vec"));

		VectorUtils.nearest(vec, "dalek", 10);
		VectorUtils.nearest(vec, "cyberman", 10);

	}
}
