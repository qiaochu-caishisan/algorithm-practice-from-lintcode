Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

How we serialize an undirected graph:

Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
这道题的意思就是返回一个图的深拷贝 一般来说和linkedlist一样 图的深拷贝也要使用hashmap 即map里面放的是旧的node和新的node的映射 注意的是
必须是深拷贝 所以所有的新的node都必须是new出来的 让Java给你重新分配地址 这道题 分为三步 第一步就是使用BFS（利用queue)来找到这个图里的所有的node
值得借鉴的是之前我不知道应该怎么避免有重复的node出现 现在知道了可以在queue之外再加上一个hashset这样的话 就可以有效地避免重复元素的出现 然后呢 在
hashmap里面建立起新旧之间的映射 然后再给新的node加上新的边 也就是neighbors那个arraylist 然后就完成了深拷贝啦
