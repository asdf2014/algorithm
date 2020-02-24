# 执行用时 : 28 ms
# 内存消耗 : 11.7 MB

# 方案：遍历一次，引入p和q指针

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        # https://camo.githubusercontent.com/924b2f1fa55fa69803f5bd510dbfc70212b9d0ac/68747470733a2f2f626c6f672d313235373132363534392e636f732e61702d6775616e677a686f752e6d7971636c6f75642e636f6d2f626c6f672f78627971302e676966

        # 创建虚拟头，将其连在链表头部
        dummyHead = ListNode(0)
        dummyHead.next = head

        # 双指针，都从虚拟头部开始
        p = q = dummyHead

        # 滑动q到 和p间距为n 为止
        idx = 0
        while idx <= n:
            q = q.next
            idx += 1

        # 滑动q到 q为末尾结点None为止，此时p在要删除的结点前一位
        while q:
            p = p.next
            q = q.next

        # 删除p.next结点
        del_node = p.next
        p.next = del_node.next
        del del_node

        # 新的头结点，删除旧虚拟头结点
        result_node = dummyHead.next
        del dummyHead

        return result_node
