Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a destination position, return the length of the route. 
Return -1 if knight can not reached.

Example
[[0,0,0],
 [0,0,0],
 [0 0 0]]
source = [2, 0] destination = [2, 2] return 2

[[0,1,0],
 [0,0,0],
 [0 0 0]]
source = [2, 0] destination = [2, 2] return 6

[[0,1,0],
 [0,0,1],
 [0 0 0]]
source = [2, 0] destination = [2, 2] return -1
本题是很简单的BFS题目 唯一一个问题就在于用棋盘本身去重，即将走过的地方改成1 而不是用set用set就会超过时间复杂度和空间复杂度
