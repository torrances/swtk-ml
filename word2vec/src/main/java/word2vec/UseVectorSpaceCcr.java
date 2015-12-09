package word2vec;

import java.io.File;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;

import word2vec.util.VectorUtils;

public class UseVectorSpaceCcr {

	

	public static void main(String... args) throws Throwable {

		WordVectors vec = WordVectorSerializer.loadTxtVectors(new File("/Users/craigtrim/Desktop/word2vec/ccr/vec/ccr006.vec"));

		word2vec.util.VectorUtils.nearest(vec, "siltstones", 10);
		word2vec.util.VectorUtils.s(vec, "trap", "anticlines");	
		VectorUtils.nearest(vec, "siltstones", "reservoir", "fan-abandonment", 10);
		VectorUtils.nearest(vec, "siltstones", "shale", "fan-abandonment", 10);
		VectorUtils.nearest(vec, "siltstones", "mudstones", "fan-abandonment", 10);
		VectorUtils.nearest(vec, "siltstones", "sandstones", "fan-abandonment", 10);
	}
}
