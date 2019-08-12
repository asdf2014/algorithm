# 思路

1. 选取两个下标left, right
2. if array[left] < array[right] then left++ else right--
3. 将下标的面积与每次缓存的最大值进行比较.


## 代码

```python3

def solution(array):
    l, r = 0, len(array) - 1
    max_area = 0

    while l < r:
        max_area = max(max_area, min(array[l], array[r]) * (r - l))

        if (array[l] < array[r]):
            l += 1
        else:
            r -= 1
    return max_area
```
