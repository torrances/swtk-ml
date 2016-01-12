package org.swtk.dl4j.w2v.drwho.svc;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;

import com.trimc.blogger.commons.utils.map.MapUtils;

public class UseVectorSpaceDrWho2 {

	public static void main(String... args) throws Throwable {

		WordVectors vec = WordVectorSerializer.loadTxtVectors(new File("/Users/craigtrim/Desktop/drwho/vec/drwho005.vec"));

		next(new HashMap<String, String>(), vec, "dalek", 0, 10);

	}

	private static void next(Map<String, String> map, WordVectors vec, String term, int spaces, int n) {

		System.err.println(spaces(spaces) + term);

		Collection<String> list = vec.wordsNearest(term, 10);

		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {

			String nearest = iter.next();

			int count = map.keySet().contains(nearest) ? (Integer.parseInt(map.get(nearest))) : 0;
			if (count <= 10) {

				MapUtils.add2Map(map, nearest);
				next(map, vec, nearest, spaces + 1, 10);
			}
		}
	}

	private static String spaces(int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++)
			sb.append(" ");

		return sb.toString();
	}
}
