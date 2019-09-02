按照官网题解写的，有待加入自己的思考

```python
class Solution(object):
    def findMedianSortedArrays(self, A, B):
        """
        :type A: List[int] 
        :type B: List[int]
        :rtype: float
        """
        m, n = len(A), len(B)
        if m > n:
            A, B, m, n = B, A, n, m
        if n == 0:
            raise ValueError

        imin, imax, half_len = 0, m, (m + n + 1) / 2
        while imin <= imax:
            i = (imin + imax) / 2
            j = half_len - i
            if i < m and B[j-1] > A[i]:
                # i is too small, must increase it
                imin = i + 1
            elif i > 0 and A[i-1] > B[j]:
                # i is too big, must decrease it 
                imax = i - 1
            else:
                # i is perfect

                if i == 0: max_of_left = B[j-1]
                elif j == 0: max_of_left = A[i-1]
                else: max_of_left = max(A[i-1], B[j-1])

                if (m + n) % 2 == 1:
                    return max_of_left

                if i == m: min_of_right = B[j]
                elif j == n: min_of_right = A[i]
                else: min_of_right = min(A[i], B[j])

                return (max_of_left + min_of_right) / 2.0
```

找出第k个元素的思路
```python
import sys


class Solution(object):
    def findMedianSortedArrays(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: float
        """
        m = len(A)
        n = len(B)
        if m == 0:
            if n % 2 != 0:
                return 1.0 * B[n // 2]
            return (B[n // 2] + B[n // 2 - 1]) / 2.0
        if n == 0:
            if m % 2 != 0:
                return 1.0 * A[m // 2]
            return (A[m // 2] + A[m // 2 - 1]) / 2.0

        total = n + m
        if (total & 1) == 1:
            return self.findKth(A, 0, B, 0, total // 2 + 1)
        return (self.findKth(A, 0, B, 0, total // 2) + self.findKth(A, 0, B, 0, total // 2 + 1)) / 2.0

    def findKth(self, A, a_st, B, b_st, k) -> float:
        global mid_b, mid_a
        if a_st >= len(A):
            return B[b_st + k - 1]
        if b_st >= len(B):
            return A[a_st + k - 1]

        if k == 1:
            return min(A[a_st], B[b_st])

        mid_a = sys.maxsize
        mid_b = sys.maxsize

        if a_st + k // 2 - 1 < len(A):
            mid_a = A[a_st + k // 2 - 1]

        if b_st + k // 2 - 1 < len(B):
            mid_b = B[b_st + k // 2 - 1]

        if mid_a < mid_b:
            return self.findKth(A, a_st + k // 2, B, b_st, k - k // 2)
        return self.findKth(A, a_st, B, b_st + k // 2, k - k // 2)


if __name__ == '__main__':
    s = Solution()
    print(s.findMedianSortedArrays([1], [2, 3, 4, 5, 6]))



```