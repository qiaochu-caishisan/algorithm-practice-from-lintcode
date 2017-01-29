Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Find the number of islands.
Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.本题用优化之后的DFS去解  一开始想使用扫描之后然后挨个点进行DFS然后用一个visited数组来记录是否访问过 但是超时了。。。。可能是有path这样的操作  这种优化之后的方法没有多余的操作 还算比较快
