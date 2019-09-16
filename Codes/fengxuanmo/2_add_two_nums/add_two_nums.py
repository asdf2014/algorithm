#! coding:utf-8


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

def addTwoNumbers(l1, l2):
    """
    :type l1: ListNode
    :type l2: ListNode
    :rtype: ListNode
    """

    # Definition for singly-linked list.
    # class ListNode:
    #     def __init__(self, x):
    #         self.val = x
    #         self.next = None
    head = ListNode(0)
    jin_wei = 0  # 进位和
    cur = head
    while l1 or l2:
        #判断当前节点是否为None，而不是下一个节点，不然第一步进入不了
        x = l1.val if l1 else 0
        y = l2.val if l2 else 0
        he = jin_wei + x + y
        jin_wei = he // 10
        cur.next = ListNode(he % 10)
        cur = cur.next
        if l1 != None: l1 = l1.next
        if l2 != None: l2 = l2.next
    if jin_wei > 0:
        cur.next = ListNode(1)
    return head.next

#
# if __name__ == '__main__':
#     addTwoNumbers()
