

暴力破解
```python
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carry = 0
        res = ListNode(0)
        curr = res
        while l1 or l2:
            x = l1.val if l1 else 0
            y = l2.val if l2 else 0
            sums = x + y + carry
            carry = sums // 10
            curr.next = ListNode(sums % 10)
            curr = curr.next
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
            if not l1 and not l2:
                break
        if carry > 0:
            curr.next = ListNode(carry)
        return res.next
```


递归破解

```python
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def addTwoNumbers(self, l1: ListNode, l2: ListNode, carry=0) -> ListNode:
    if not (l1 or l2):
        return ListNode(1) if carry else None
    l1, l2 = l1 or ListNode(0), l2 or ListNode(0)
    val = l1.val + l2.val + carry
    l1.val, l1.next = val % 10, self.addTwoNumbers(l1.next, l2.next, val > 9)
    return l1
```