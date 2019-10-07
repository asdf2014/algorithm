```python
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def isPalindrome(self, head: ListNode):
        if not head or not head.next:
            return True
        fast = head
        slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next

        slow = slow.next
        slow = self.reverse(slow)
        
        while head and slow:
            if head.val == slow.val:
                head = head.next
                slow = slow.next
            else:
                return False
            
        return True

    def reverse(self, head: ListNode):
        prev = None
        curr = head
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev


if __name__ == '__main__':
    node = ListNode(1)
    node.next = ListNode(2)
    node.next.next = ListNode(2)
    node.next.next.next = ListNode(1)
    s = Solution()
    
    print(s.isPalindrome(node))
```