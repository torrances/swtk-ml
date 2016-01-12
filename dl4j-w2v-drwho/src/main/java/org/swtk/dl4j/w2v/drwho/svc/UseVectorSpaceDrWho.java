package org.swtk.dl4j.w2v.drwho.svc;

import java.io.File;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;
import org.swtk.dl4j.w2v.core.utils.VectorUtils;

public class UseVectorSpaceDrWho {

	public static void main(String... args) throws Throwable {

		WordVectors vec = WordVectorSerializer.loadTxtVectors(new File("/Users/craigtrim/Desktop/drwho/vec/drwho005.vec"));

		//		VectorUtils.s(vec, "alpha", "dalek");
		//		VectorUtils.s(vec, "blah blah", "dalek");
		//		VectorUtils.s(vec, "doctor", "dalek");
		//		VectorUtils.s(vec, "dr-who", "dalek");
		//		VectorUtils.s(vec, "doctor", "master");
		//		VectorUtils.s(vec, "doctor", "davros");
		//		VectorUtils.s(vec, "dalek", "davros");
		//		VectorUtils.s(vec, "doctor", "time lord");
		//		VectorUtils.s(vec, "tardis", "doctor");
		//		VectorUtils.s(vec, "tardis", "dr-who");
		//		VectorUtils.s(vec, "dr-who", "doctor");
		//		VectorUtils.s(vec, "strax", "sontaran");
		//		VectorUtils.s(vec, "skaro", "dalek");
		//		VectorUtils.s(vec, "skaro", "davros");
		//		VectorUtils.s(vec, "k9", "drwho");

		VectorUtils.nearest(vec, "dalek", 10);
		//		VectorUtils.nearest(vec, "cyberman", 10);
		//		VectorUtils.nearest(vec, "sontaran", 10);
		//		VectorUtils.nearest(vec, "davros", 10);
		//		VectorUtils.nearest(vec, "tardis", 10);
		//		VectorUtils.nearest(vec, "skaro", 10);
		//		VectorUtils.nearest(vec, "k9", 10);
		//
		//		// king1 - queen3 + woman2 = man
		//		VectorUtils.nearest(vec, "dr-who", "dalek", "tardis", 10);
		//		VectorUtils.nearest(vec, "dr-who", "dalek", "k9", 10);
		//		VectorUtils.nearest(vec, "dr-who", "dalek", "clara", 10);
		//		VectorUtils.nearest(vec, "skaro", "earth", "dalek", 10);

		//Utils.nearest(vec, Arrays.asList("doctor), list2, n);

		// doctor, tardis, dalek = lisa 		(doctor - dalek + tardis = lisa)
		// doctor, dalek, tardis = residence 	(doctor - tardis + dalek = residence)
		//										(doctor - tardis = dalek - residence)

	}
}
