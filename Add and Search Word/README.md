Design a data structure that supports the following two operations: addWord(word) and search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or ..

A . means it can represent any one letter.

Example
addWord("bad")
addWord("dad")
addWord("mad")
search("pad")  // return false
search("bad")  // return true
search(".ad")  // return true
search("b..")  // return true

TRIE树数据结构的第一题 .的处理方法使用递归 差不多等于深搜
