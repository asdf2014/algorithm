# -*- coding: utf-8 -*-
# URL : https://leetcode-cn.com/problems/add-two-numbers/

""""""

"""
problem:
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
"""

"""
explain:
遍历相加，把结果叠加到一个链表中去，并算出下一个进位值。
退出循环后，如果另一个链表还有数据，就将之前的链表尾部指向另一个链表的剩下的所有节点
"""

"""
out:
执行用时 : 72 ms, 在所有 python3 提交中击败了 90.83% 的用户
内存消耗 : 12.7 MB, 在所有 python3 提交中击败了 99.59% 的用户
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        # condition：非空
        overflow = 0
        pre1 = l1
        node1 = l1
        node2 = l2

        while node1 is not None and node2 is not None:
            sum = overflow + node1.val + node2.val

            # reset and next overflow
            # equals ：node1.val, overflow = sum % 10, sum // 10
            # reset
            overflow = 0

            # next overflow
            while sum >= 10:
                sum -= 10
                overflow += 1
            node1.val = sum

            # next
            pre1 = node1
            node1 = node1.next
            node2 = node2.next

        def single_add(node, overflow):
            pre = node
            while overflow > 0:
                # 最后的进位
                if node is None:
                    pre.next = ListNode(overflow)
                    break
                sum = overflow + node.val
                # reset
                overflow = 0

                # next overflow
                while sum >= 10:
                    sum -= 10
                    overflow += 1
                node.val = sum

                # next
                pre = node
                node = node.next

        if node2 is not None:
            node22 = node2
            single_add(node2, overflow)
            pre1.next = node22  # 追加
        elif node1 is not None:
            single_add(node1, overflow)
        elif overflow > 0:
            pre1.next = ListNode(overflow)

        return l1


if __name__ == "__main__":
    # 建立单链表
    def build_node(arr):
        head = None
        node = None
        for e in arr:
            if head is None:
                head = ListNode(e)
                node = head
            else:
                node.next = ListNode(e)
                node = node.next
        return head

    # 链表转数组
    def make_arr(node: ListNode):
        arr = []
        while node is not None:
            arr.append(node.val)
            node = node.next
        return arr

    solution = Solution()
    assert make_arr(
        solution.addTwoNumbers(build_node([2, 4, 3]), build_node([5, 6, 4]))
    ) == [7, 0, 8]
    assert make_arr(
        solution.addTwoNumbers(build_node([2, 4]), build_node([5, 6, 4]))
    ) == [7, 0, 5]
    assert make_arr(
        solution.addTwoNumbers(build_node([2, 4]), build_node([5, 6, 9, 9, 9]))
    ) == [7, 0, 0, 0, 0, 1]
