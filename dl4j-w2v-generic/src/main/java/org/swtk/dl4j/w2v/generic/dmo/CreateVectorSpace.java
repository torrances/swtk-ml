package org.swtk.dl4j.w2v.generic.dmo;

import java.util.ArrayList;

import org.deeplearning4j.models.embeddings.WeightLookupTable;
import org.deeplearning4j.models.embeddings.inmemory.InMemoryLookupTable;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.models.word2vec.wordstore.inmemory.InMemoryLookupCache;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.sentenceiterator.UimaSentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.swtk.dl4j.w2v.generic.dto.FileContract;
import org.swtk.dl4j.w2v.generic.dto.Word2VecContract;

public class CreateVectorSpace {

	private Word2Vec build(Word2VecContract contract, SentenceIterator iter, TokenizerFactory tok, WeightLookupTable table, InMemoryLookupCache cache) {
		Word2Vec vec = new Word2Vec.Builder()

		/*			*/.batchSize(contract.getBatchSize())

		/*			*/.sampling(contract.getSampling())

		/*			*/.minWordFrequency(contract.getMinWordFrequency())

		/*			*/.iterations(contract.getIterations())

		/*			*/.layerSize(contract.getLayerSize())

		/*			*/.lookupTable(table)

		/*			*/.stopWords(new ArrayList<String>())

		/*			*/.negativeSample(contract.getNegativeSample())

		/*			*/.vocabCache(cache)

		/*			*/.seed(42)

		/*			*/.learningRate(contract.getLearningRate())

		/*			*/.minLearningRate(contract.getMinLearningRate())

		/*			*/.windowSize(5)

		/*			*/.iterate(iter).tokenizerFactory(tok).build();

		return vec;
	}

	public void process(FileContract fileContract, Word2VecContract contract) throws Exception {

		/*	strip white space before and after for each line */
		SentenceIterator iter = UimaSentenceIterator.createWithPath(fileContract.getInputFile());

		/*	split on white spaces in the line to get words	*/
		TokenizerFactory tok = new DefaultTokenizerFactory();

		/*	choose the pre-processor 						*/
		tok.setTokenPreProcessor(new CommonPreprocessor());

		/*	choose the cache								*/
		InMemoryLookupCache cache = new InMemoryLookupCache();

		/*	build weight lookup table						*/
		WeightLookupTable table = new InMemoryLookupTable.Builder().vectorLength(contract.getVectorLength()).useAdaGrad(false).cache(cache).lr(contract.getLearningRate()).build();

		/*	build the vector								*/
		Word2Vec vec = build(contract, iter, tok, table, cache);

		/*	train the vector 								*/
		vec.fit();

		/*	serialize the model to file						*/
		WordVectorSerializer.writeWordVectors(vec, fileContract.getOutputFile());
	}
}
