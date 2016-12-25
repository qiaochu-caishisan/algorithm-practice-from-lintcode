Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
实现 cache的LRU策略 本题其实不难 一开始想到的办法是用一个hashmap和一个queue来实现 但是发现其实不太好 因为cache是一个结构 而且这个方法不知道为什么总是出错
所以就使用了答案的方法 就是用一个hashmap来实现 hashmap的映射从key到一个node这个node就是一个linklist的一部分 这样的话就可以模拟 队列的操作 更加精妙
