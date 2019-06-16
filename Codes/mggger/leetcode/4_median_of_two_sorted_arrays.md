# 思路

题目要求: 时间复杂度 O(log(m+n))

二分查找法

```
left                   |  right
A[0], A[1], ... A[i-1] |   A[i], A[i+1], A[m] 
B[0], B[1], ... B[j-1] |   B[j], B[j+1], B[n] 
```
将2个已排序的数组A，B分成left， right两部分, 

只需要确保两个条件，
- len(left) == len(right)
- A[i-1] <= B[j] and B[j-1] <= A[i]

就可求取中位数, 如果m + n为奇数, median:  **max(A[i-1], B[j-1]) / 1.0**   
  
否则 median: **(max(A[i-1], B[j-1]) + min(A[i], B[j])) / 2.0**

***
1. i + j = m - i + n - j
   
   =>
     
   i查找的范围为 0 ~ m , j = (m + n + 1) / 2 - i

2. iMin = 0， iMax = m,  i = （iMin + iMax) / 2
    - 如果A[i-1] > B[j] and i > 0,  减小iMax
    - 如果B[j-1] > A[i] and i < m,  增加iMin
    - 如果满足条件A[i-1] <= B[j] and B[j-1] <= A[i]
        + 如果i == 0, max_left = B[j-1]  
        + 如果j == 0, max_left = A[i-1]
        + 如果i == m, max_right = B[j]
        + 如果j == n, max_right = A[i]

## 代码
```python
def solution(nums1, nums2):
    if len(nums1) > len(nums2):
        nums1, nums2 = nums2, nums1

    m, n = len(nums1), len(nums2)

    imin, imax = 0, m

    while imax <= imax:
        i = int((imin + imax) / 2)
        j = int((m + n + 1) / 2) - i

        if i > 0 and nums1[i - 1] > nums2[j]:
            imax = i - 1

        elif i < m and nums2[j - 1] > nums1[i]:
            imin = i + 1

        else:
            if i == 0:
                max_of_left = nums2[j - 1]
            elif j == 0:
                max_of_left = nums1[i - 1]
            else:
                max_of_left = max(nums1[i - 1], nums2[j - 1])

            if (m + n) % 2 == 1:
                return max_of_left / 1

            if i == m:
                min_of_right = nums2[j]
            elif j == n:
                min_of_right = nums1[i]
            else:
                min_of_right = min(nums1[i], nums2[j])

            return (max_of_left + min_of_right) / 2
```

### Testcast
```python
print(solution([1, 2], [3, 4]))
```