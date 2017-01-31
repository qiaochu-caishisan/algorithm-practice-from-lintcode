An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.
这道题 用宽搜的话会超出空间 所以用二分 不需要queue
