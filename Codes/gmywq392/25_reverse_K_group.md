```python
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        stack = []
        dummy = ListNode(0)
        dummy.next = head
        curr = dummy
        next = dummy.next

        def no_empty(node, k):
            for i in range(k):
                if node:
                    node = node.next
                else:
                    return False

        while no_empty(next, k):
            for i in range(k):
                stack.append(next)
                next = next.next
            while stack:
                curr.next = stack.pop()
                curr = curr.next
            curr.next = next
        return dummy.next
```