Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
  这道题在难度上属于hard的题目 但是其实并不是特别难 一开始我的方向就是正确的 即这道题的伪装下 其实就是一道图论的最短路径的题目！和六度问题是有一定相似度的 
 
 但是这道题的启示点在于 不用成图也可以做深搜回溯 用string 模拟图的样子就好 然后难点在于超时问题，如果一开始不解决最短路径而是放在最后解决就会导致超时
所以我们增加了一个hashmap记录距离start的distance然后每次前进一步保证是最短的 可以读读代码 我在里面写了注释 可以快速看懂
