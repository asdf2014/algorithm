```python
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.next = None
        self.val = x


class Solution(object):
    def swapPairs(self, head: ListNode):
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy
        while prev and prev.next:
            l1 = prev.next
            l2 = prev.next.next
            l1.next = l2.next
            l2.next = l1
            prev.next = l2
            prev = l1
        return dummy.next


if __name__ == '__main__':
    node = ListNode(1)
    node.next = ListNode(2)
    node.next.next = ListNode(3)
    node.next.next.next = ListNode(4)
    s = Solution()

    print(s.swapPairs(node))
```