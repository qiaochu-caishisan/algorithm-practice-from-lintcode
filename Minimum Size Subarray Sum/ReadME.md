Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.

Have you met this question in a real interview? Yes
Example
Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.

Challenge 
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
这道题的主要思想就是说 我们先想到一个n平方的暴力办法解决问题 即对于i = 0 考虑j = 1,2,3,4,5..... 对于i = 1 考虑j = 1,2,3,4,5...以此类推
找到最短的subarray 但是时间复杂度不好 我们想想如何剪枝？ 实际上如果i  = 0, j = 2不满足 大于等于s的话 那么i = 1, j = 2是一定不满足的 这一种情况是可以剪掉的
所以通过这种办法 可以用双指针解决这道问题
