/**
 * 
 */
package com.huaban.analysis.jieba.lucene;

import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;
import org.apache.lucene.analysis.Analyzer;

import java.io.Reader;

/**
 * @author zhangcheng
 *
 */
public class JiebaAnalyzer extends Analyzer {
	
	private String segMode;

	/**
	 * 
	 */
	public JiebaAnalyzer() {
		this(SegMode.INDEX.name());
	}
	
	public JiebaAnalyzer(String segMode) {
		this.segMode = segMode;
	}

	/**
	 * @param reuseStrategy
	 */
	public JiebaAnalyzer(ReuseStrategy reuseStrategy) {
		super(reuseStrategy);
	}

	@Override
	protected TokenStreamComponents createComponents(String field) {
		return new TokenStreamComponents(new JiebaTokenizer(this.segMode));
	}
}
