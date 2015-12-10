package org.swtk.ml.w2v.core.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;

public class VectorUtils {

	public static void nearest(WordVectors vec, String term, int n) {
		Collection<String> list = vec.wordsNearest(term, n);
		System.err.println("nearest-" + n + ":" + term + " = (" + VectorUtils.toString(list) + ")");
	}

	public static void nearest(WordVectors vec, String t1, String t2, String t3, int n) {

		/*	The classic example of Word2vec’s arithmetic of words is 
		 * 		“king - queen = man - woman” 
		 * 		t1 - t3 = t4 - t2
		 * 	and its logical extension 
		 * 		“king - queen + woman = man”.
		 * 		t1 - t3 + t2 = t4
		 * Collection<String> kingList = vec.wordsNearest(Arrays.asList("king", "woman"), Arrays.asList("queen"), 10); */
		Collection<String> t4s = vec.wordsNearest(Arrays.asList(t1, t2), Arrays.asList(t3), n);

		String result = "t1 - t3 = (t4) - t2";
		result = result.replaceAll("t1", t1);
		result = result.replaceAll("t2", t2);
		result = result.replaceAll("t3", t3);
		result = result.replaceAll("t4", toString(t4s));

		System.err.println(result);
	}

	public static void s(WordVectors vec, String term1, String term2) {
		double score = vec.similarity(term1, term2);
		System.err.println(term1 + ":" + term2 + " = " + score);
	}

	public static String toString(Collection<String> list) {
		StringBuilder sb = new StringBuilder();

		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			sb.append(iter.next());
			if (iter.hasNext()) sb.append(", ");
		}

		return sb.toString();
	}
}
