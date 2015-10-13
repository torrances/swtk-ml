package word2vec.dmo;

import org.deeplearning4j.text.tokenization.tokenizer.TokenPreProcess;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.EndingPreProcessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;

public class CreateTokenizer {

	public static TokenizerFactory process() {
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

		return tokenizer;
	}
}
