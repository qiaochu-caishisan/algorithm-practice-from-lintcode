Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Return null if LCA does not exist.

 Notice

node A or node B may not exist in tree.
本道题与前两题即1 2的区别在于 node A 和node B 可能并不存在这个树里；所以我就直接在前面用一个preorder 遍历 把这个树的node过一遍 然后看看是否在里面
感觉这个方法并不是特好 看看答案看看有没有好的方法
