Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.

Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
本题采用的基本思想其实也是prefix sum但是要复杂得多。。。用一个pair类型的数组存起来各个sum 和这个sum的结束地方的那个index然后进行排序 因为已经排好了序 所以相邻的sums[i] 必然相差的是最接近0的 所以直接在相邻里面找最小就可以了 找到之后再输出index 注意起始的index应该是sums[i].index - 1 因为pair型数组里面存的index是这个sum的终结的index 所以要减去1
