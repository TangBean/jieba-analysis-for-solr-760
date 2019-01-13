结巴分词(java版) 适配solr 7.6.0
===============================

同时处理的结巴分词中在 dataImport 时会出现的问题：
```
possible analysis error: startOffset must be non-negative, and endOffset must be >= startOffset, and offsets must not go backwards
```
该问题是由于得到的分词结果list的排序不符合 solr 的规则导致的，solr 在 index 分词时有如下要求：
- startOffset must be non-negative
- endOffset must be >= startOffset
- offsets must not go backwards（原来的排序导致该问题）

举个例子：
对“普通话”进行分词，原来的排序方法的分词结果为：

|           |普通 | 通话 | 普通话 |
|-----------|----|------|-------|
|startOffset|0   |1     |0      |
|endOffset  |1   |2     |2      |

修改之后的排序方法为：

|           |普通 | 普通话 | 通话 |
|-----------|----|------|-------|
|startOffset|0   |0     |1      |
|endOffset  |1   |2     |2      |

dataImport恢复正常。
