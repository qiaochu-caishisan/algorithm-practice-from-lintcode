Given an array of integers, find a contiguous subarray which has the largest sum.

Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.a
Solution.java 中提供的是Greedy的做法 这种做法其实没有什么代表意义 因为一般来说我想的贪心肯定是错的 但是Solution1.java中提供的prefix sum的做法是比较有意义的 因为在数组的题目当中 其实 prefix sum、 hash、 two pointers这三种是使用比较多的解题方法 所以如果回顾的话 请仔细看看prefix sum的做法
