Implement a stack with min() function, which will return the smallest number in the stack.

It should support push, pop and min operation all in O(1) cost.
一开始拿到这道题的时候想到的是用一个priorityqueue来维护最小值 但是这种数据结构 无论是拿出来还是放进去都是logn的所以与O（1）的要求肯定是不符合的
所以就有了solution的这种做法 两个栈  一个栈是放数的 一个栈是放最小值的 在push的时候会在stack里放number 同时在minstack里面放最小值 这样的话
minstack里面的最小值的数量其实和stack里面的number的数量是一致的 这样在pop的时候就两个都pop一次 这样不会影响到正常的pop可能会影响minstack的这个问题
