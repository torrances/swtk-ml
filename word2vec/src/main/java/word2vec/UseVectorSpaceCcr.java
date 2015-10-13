package word2vec;

import java.io.File;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;

public class UseVectorSpaceCcr {

	

	public static void main(String... args) throws Throwable {

		WordVectors vec = WordVectorSerializer.loadTxtVectors(new File("/Users/craigtrim/Desktop/word2vec/ccr/vec/ccr001.vec"));

		word2vec.util.VectorUtils.nearest(vec, "reservoir", 10);
	  
	}
}
