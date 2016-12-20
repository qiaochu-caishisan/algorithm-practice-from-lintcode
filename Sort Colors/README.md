Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].快排的应用 因为要求不能使用额外空间 不然可以用merge sort 
这道题的solution的解法不是特别好 因为这道题的数字是0  1  2用快排非常浪费 不如使用solution1里的two pointers的做法 细细体会一下
