# Definition for singly-linked list.
from compiler.misc import Stack


class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head= ListNode(-1)
        cur=head
        jinwei=0
        while l1 or l2:
            t1 = l1.val if l1 else 0
            t2 = l2.val if l2 else 0
            he=t1+t2+jinwei
            jinwei=he // 10
            cur.next=ListNode(he%10)
            cur=cur.next
            if l1 !=  None:
                l1=l1.next
            if l1 != None:
                l2 = l2.next
        if jinwei > 0:
            cur.next = ListNode(1)
        return head.next




if __name__ == '__main__':
    m=Solution()
    num_a=ListNode(val=10)
    num_b = ListNode(val=10)
    m.addTwoNumbers(num_a,num_b)