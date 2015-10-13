package word2vec.dmo;

import java.io.File;
import java.io.IOException;

import org.deeplearning4j.text.sentenceiterator.LineSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentencePreProcessor;

public class CreateSentenceIterator {

	public static SentenceIterator process(File resource) throws IOException {
		SentenceIterator iter = new LineSentenceIterator(resource);

		iter.setPreProcessor(new SentencePreProcessor() {
			private static final long serialVersionUID = -2987136190084900667L;

			@Override
			public String preProcess(String sentence) {
				return sentence.toLowerCase();
			}
		});

		return iter;
	}
}
