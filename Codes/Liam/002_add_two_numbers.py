#执行用时 : 48 ms
#内存消耗 : 11.8 MB

#方案：按位相加 引入(额外链表、carried变量) 额外链表记录位置结果 carried变量记录当前是否溢出

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carried = 0
        # dummy head 
        dummy_head = cur = ListNode(-1)
        # 只要有一个链表非空 就进入计算
        while l1 or l2:
            # val 重新被赋值为carried
            val = carried
            # l1.val + l2.val + carried
            # l1, l2指针后移
            if l1:
                val += l1.val
                l1 = l1.next
            if l2:
                val += l2.val
                l2 = l2.next
            # 和的个位数 给 cur的后一位
            cur.next = ListNode(val % 10)
            # cur指针后移
            cur = cur.next
            # carried 加和大于10 溢出的话 carried变成1
            carried = val / 10
        # 遍历完成之后 carried 若有溢出，给cur补位
        if carried > 0 :
            cur.next = ListNode(carried)
        return dummy_head.next
