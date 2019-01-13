package com.huaban.analysis.jieba.lucene;

import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.apache.lucene.util.AttributeSource;

import java.io.Reader;
import java.util.Map;

public class JiebaTokenizerFactory extends TokenizerFactory {
	
	private String segMode;
	
	public JiebaTokenizerFactory(Map<String, String> args) {
		super(args);
        // assureMatchVersion();
        if (null == args.get("segMode")) {
        	segMode = SegMode.SEARCH.name();
        } else {
        	segMode = args.get("segMode");
        }
	}

    @Override
    public Tokenizer create(AttributeFactory factory) {
		return new JiebaTokenizer(segMode);
	}


	public String getSegMode() {
		return segMode;
	}

	public void setSegMode(String segMode) {
		this.segMode = segMode;
	}

}
