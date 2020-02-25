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
        while prev.next and prev.next.next:
            l1 = prev.next
            l2 = prev.next.next

            l1.next = l2.next
            l2.next = l1
            prev.next = l2

            prev = prev.next.next
        return dummy.next

    def swapPairsRecursive(self, head: ListNode):
        if head is None or head.next is None: return head
        first = head
        second = head.next
        head = second
        first.next = self.swapPairsRecursive(second.next)
        second.next = first
        return head

if __name__ == '__main__':
    node = ListNode(1)
    node.next = ListNode(2)
    node.next.next = ListNode(3)
    node.next.next.next = ListNode(4)
    s = Solution()

    print(s.swapPairs(node))
    print(s.swapPairsRecursive(node))
```