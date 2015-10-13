package word2vec;

import java.io.File;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;

public class UseVectorSpaceDrWho {

	

	public static void main(String... args) throws Throwable {

		WordVectors vec = WordVectorSerializer.loadTxtVectors(new File("/Users/craigtrim/Desktop/drwho/vec/drwho005.vec"));

		Utils.s(vec, "alpha", "dalek");
		Utils.s(vec, "blah blah", "dalek");
		Utils.s(vec, "doctor", "dalek");
		Utils.s(vec, "dr-who", "dalek");
		Utils.s(vec, "doctor", "master");
		Utils.s(vec, "doctor", "davros");
		Utils.s(vec, "dalek", "davros");
		Utils.s(vec, "doctor", "time lord");
		Utils.s(vec, "tardis", "doctor");
		Utils.s(vec, "tardis", "dr-who");
		Utils.s(vec, "dr-who", "doctor");
		Utils.s(vec, "strax", "sontaran");
		Utils.s(vec, "skaro", "dalek");
		Utils.s(vec, "skaro", "davros");
		Utils.s(vec, "k9", "drwho");

		Utils.nearest(vec, "dalek", 10);
		Utils.nearest(vec, "cyberman", 10);
		Utils.nearest(vec, "sontaran", 10);
		Utils.nearest(vec, "davros", 10);
		Utils.nearest(vec, "tardis", 10);
		Utils.nearest(vec, "skaro", 10);
		Utils.nearest(vec, "k9", 10);
		
		// king1 - queen3 + woman2 = man
		Utils.nearest(vec, "dr-who", "dalek", "tardis", 10);
		Utils.nearest(vec, "dr-who", "dalek", "k9", 10);
		Utils.nearest(vec, "dr-who", "dalek", "clara", 10);
		Utils.nearest(vec, "skaro", "earth", "dalek", 10);
		
		//Utils.nearest(vec, Arrays.asList("doctor), list2, n);
		
		// doctor, tardis, dalek = lisa 		(doctor - dalek + tardis = lisa)
		// doctor, dalek, tardis = residence 	(doctor - tardis + dalek = residence)
		//										(doctor - tardis = dalek - residence)
	  
	}
}
