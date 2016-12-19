Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.

Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
Solution的解法是采用了暴力解的方法。。。不知道为什么就莫名其妙地过了。。。。。

Solution1 的解法是比较有意思的  使用了hashmap 这个map记住每一个sum然后当后续的sum有和map里面的元素相同的时候 就说明从之前的sum之后的那一个元素到相同的那个元素形成的sum这一段的sum是0  所以就得到了sum是0的subarray 这一题要细细 体味这种思维 可以应用到很多题当中
