
```python
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head

        first = dummy
        for i in range(n + 1):
            first = first.next

        second = dummy

        while first is not None:
            first = first.next
            second = second.next

        second.next = second.next.next

        return dummy.next

```
