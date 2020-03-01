# 执行用时 : 68 ms
# 内存消耗 : 16.6 MB

# 方案：哨兵结点 sentinel，插入在head结点之前

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        # 哨兵结点 sentinel，插入在head结点之前
        sentinel = ListNode(0)
        sentinel.next = head

        # 初始化两个指针 curr 和 prev
        prev, curr = sentinel, head
        while curr:
            if curr.val == val:
                prev.next = curr.next
            else:
                prev = curr
            # 遍历下一个元素
            curr = curr.next

        return sentinel.next
