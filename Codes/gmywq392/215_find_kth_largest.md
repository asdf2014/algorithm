```python3
import time
from typing import List


def partition(nums, l, r):
    i = l - 1
    pivot = nums[r]
    for j in range(l, r):
        if nums[j] >= pivot:
            i += 1
            nums[j], nums[i] = nums[i], nums[j]
    nums[i + 1], nums[r] = nums[r], nums[i + 1]
    return i + 1


class Solution:
    def findKthLargest2(self, nums: List[int], k: int) -> int:
        return sorted(nums, reverse=True)[k - 1]

    def findKthLargest3(self, nums: List[int], k: int) -> int:
        # 优先队列
        # 遍历入队列
        # 如果 队列大小 大于 k 并且 队列顶元素 大于 当前入队元素则跳过
        # 入队
        # 如果 队列大小 大于 k 则出队一个
        pass

    def findKthLargest(self, nums: List[int], k: int) -> int:
        self.quick(nums, 0, len(nums) - 1, k)
        return nums[k - 1]

    def quick(self, nums, start, end, k):
        # st = []
        # st.append(start)
        # st.append(end)
        # while st:
        #     r = st.pop()
        #     l = st.pop()
        #     if l <= r:
        #         p = partition(nums, l, r)
        #         st.append(p + 1)
        #         st.append(r)
        #         st.append(l)
        #         st.append(p - 1)
        if start < end:
            p = partition(nums, start, end)
            if p > k - 1:
                self.quick(nums, start, p - 1, k)
            else:
                self.quick(nums, p + 1, end, k)

solution = Solution()
start = time.time()
largest = solution.findKthLargest(
    [3, 2, 1, 5, 6, 4, 8, 9, -1, 210, 2]
    , 2)
end = time.time()
print(largest, end - start)
```