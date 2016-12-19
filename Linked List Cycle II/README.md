Given a linked list, return the node where the cycle begins.

If there is no cycle, return null.
这道题的思路就是先是用判断是否成环的方法 快慢指针往前走 然后快慢指针相遇之后，从head再出发一个指针，慢指针从相遇的地方出发 然后当慢指针的下一个就是head出发的指针的时候 head出发的指针的位置就是cycle起点
