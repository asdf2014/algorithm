```python3
import time
from typing import List


class Solution:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        self.quick(arr, 0, len(arr) - 1, k)
        return arr[:k]

    def quick(self, arr, start, end, k):

        while start < end:
            mid = start + (end - start) // 2
            if arr[mid] > arr[end]: swap(arr, mid, end)
            if arr[start] > arr[end]: swap(arr, start, end)
            if arr[mid] > arr[start]: swap(arr, mid, start)
            pivot = arr[start]
            i, j = start, end
            while i <= j:
                while i <= j and arr[i] < pivot: i += 1
                while i <= j and arr[j] > pivot: j -= 1
                if i <= j:
                    swap(arr, i, j)
                    i += 1
                    j -= 1

            if i >= k:
                end = i - 1
            else:
                start = i


def swap(arr, s, t):
    arr[s], arr[t] = arr[t], arr[s]


if __name__ == "__main__":
    solution = Solution()
    print(solution.getLeastNumbers([1, 2, 3, 4, 5, 6, 7, 8], 2))
```