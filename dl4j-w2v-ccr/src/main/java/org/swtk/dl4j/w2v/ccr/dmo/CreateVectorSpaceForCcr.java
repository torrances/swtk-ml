package org.swtk.dl4j.w2v.ccr.dmo;

import java.io.File;
import java.util.ArrayList;

import org.deeplearning4j.models.embeddings.WeightLookupTable;
import org.deeplearning4j.models.embeddings.inmemory.InMemoryLookupTable;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.models.word2vec.wordstore.inmemory.InMemoryLookupCache;
import org.deeplearning4j.text.sentenceiterator.LineSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentencePreProcessor;
import org.deeplearning4j.text.tokenization.tokenizer.TokenPreProcess;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.EndingPreProcessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;

public class CreateVectorSpaceForCcr {

	public static void main(String... args) throws Throwable {

		SentenceIterator iter = new LineSentenceIterator(new File("/Users/craigtrim/data/Data/ong/ccr-all-utf16le.txt"));
		iter.setPreProcessor(new SentencePreProcessor() {
			private static final long serialVersionUID = -2987136190084900667L;

			@Override
			public String preProcess(String sentence) {
				return sentence.toLowerCase();
			}
		});

		final EndingPreProcessor preProcessor = new EndingPreProcessor();
		TokenizerFactory tokenizer = new DefaultTokenizerFactory();
		tokenizer.setTokenPreProcessor(new TokenPreProcess() {
			@Override
			public String preProcess(String token) {
				token = token.toLowerCase();
				String base = preProcessor.preProcess(token);
				base = base.replaceAll("\\d", "d");
				if (base.endsWith("ly") || base.endsWith("ing")) System.out.println();
				return base;
			}
		});

		InMemoryLookupCache cache = new InMemoryLookupCache();
		WeightLookupTable table = new InMemoryLookupTable.Builder().vectorLength(100).useAdaGrad(false).cache(cache).lr(0.025f).build();

		Word2Vec vec = new Word2Vec.Builder().minWordFrequency(3) // 1
				.batchSize(1000) // n/a
				.iterations(50) // 1
				.layerSize(300) // 100
				.learningRate(0.025) // n/a
				.lookupTable(table).stopWords(new ArrayList<String>()).vocabCache(cache).seed(42).windowSize(5).iterate(iter).tokenizerFactory(tokenizer).build();

		vec.fit();
		WordVectorSerializer.writeWordVectors(vec, "/Users/craigtrim/Desktop/ccr001.vec");
	}
}
