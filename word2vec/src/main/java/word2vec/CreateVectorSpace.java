package word2vec;

import java.io.File;
import java.util.ArrayList;

import org.deeplearning4j.models.embeddings.WeightLookupTable;
import org.deeplearning4j.models.embeddings.inmemory.InMemoryLookupTable;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.models.word2vec.wordstore.inmemory.InMemoryLookupCache;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;

import word2vec.dmo.CreateSentenceIterator;
import word2vec.dmo.CreateTokenizer;
import word2vec.dto.Contract;
import word2vec.dto.adapter.ContractAdapter;

public class CreateVectorSpace {

	public static void main(String... args) throws Throwable {
		Contract contract = ContractAdapter.transform(args);

		SentenceIterator iter = CreateSentenceIterator.process(new File(contract.getInputFile()));
		TokenizerFactory tokenizer = CreateTokenizer.process();

		InMemoryLookupCache cache = new InMemoryLookupCache();
		WeightLookupTable table = new InMemoryLookupTable.Builder().vectorLength(100).useAdaGrad(false).cache(cache).lr(0.025f).build();

		Word2Vec vec = new Word2Vec.Builder().minWordFrequency(3) // 1
				.batchSize(contract.getBatchSize()) // n/a
				.iterations(contract.getIterations()) // 1
				.layerSize(contract.getLayerSize()) // 100
				.learningRate(contract.getLearningRate()) // n/a
				.lookupTable(table).stopWords(new ArrayList<String>())
				.vocabCache(cache).seed(contract.getSeed())
				.windowSize(contract.getWindowSize())
				.iterate(iter).
				tokenizerFactory(tokenizer).build();

		vec.fit();
		WordVectorSerializer.writeWordVectors(vec, contract.getOutputFile());
	}
}
