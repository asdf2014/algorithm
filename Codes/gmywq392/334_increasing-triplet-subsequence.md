```python3
from typing import List


class Solution:

    def increasingTriplet(self, nums: List[int]) -> bool:
        if len(nums) < 3: return False 
        min = (1 << 31) - 1
        sec_min = (1 << 31) -1
        for i in nums:
            if i <= min:
                min = i
            elif i < sec_min:
                sec_min = i 
            elif i > sec_min:
                return True
        return False
if __name__ == '__main__':
    node = ListNode(1)
    node.next = ListNode(2)
    node.next.next = ListNode(2)
    node.next.next.next = ListNode(1)
    s = Solution()
    
    print(s.isPalindrome(node))
```