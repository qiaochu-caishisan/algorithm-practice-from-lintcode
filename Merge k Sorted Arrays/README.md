Given k sorted integer arrays, merge them into one sorted array.
Given 3 sorted arrays:

[
  [1, 3, 5, 7],
  [2, 4, 6],
  [0, 8, 9, 10, 11]
]
return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
Solution用的是O（n*k)的做法 其实并不是很好 Solution1用的方法更好 O（n)?的 就是先把每一个二维数组的开头装进去 然后再先拿出来 拿到哪一行的就先继续把那一行的装进去 一边装 一边拿 如果拿到下一行的就证明有别的行的比这一行的更小 然后就继续装那个行的  这样就能保证 按顺序取出来 然后也不会导致时间复杂度上升
