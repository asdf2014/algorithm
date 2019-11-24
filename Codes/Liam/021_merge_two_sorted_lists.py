#执行用时 : 20 ms
#内存消耗 : 11.8 MB

#方案：递归

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        # 处理空情况
        if l1 == None:
            return l2
        elif l2 == None:
            return l1
        else:
            # 选小的头为第一个结点 且 将小的那个列表后移一位
            if l1.val < l2.val:
                new_head = l1
                new_head.next = self.mergeTwoLists(l1.next, l2)
            else:
                new_head = l2
                new_head.next = self.mergeTwoLists(l1, l2.next)
            return new_head
        
