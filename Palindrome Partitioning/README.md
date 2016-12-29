Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.
Example
Given s = "aab", return:

[
  ["aa","b"],
  ["a","a","b"]
]
这道题就是递归回溯算法的一个典型应用，先深度搜索，判断搜索到的是否符合标准 如果标准的话就继续 如果不标准的话 就删掉这个结果 然后继续 可以仔细看看代码
