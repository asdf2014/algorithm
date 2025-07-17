"""
反转一个单链表。

示例:
    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
"""

"""
想法：
很容易想到，可以遍历单链表，依次取节点值，再以头插法放到另一个新链表中。

升级：
在原链表直接改变指针方向。
在原链表上设置前后指针，遍历单链表的同时，把前指针的值赋值给后指针的next域, 即可改变链表指针方向。指针再顺链表移动。

"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        cur = head
        pre = None
        while cur:
            tmp = cur.next
            # 指针转换方向
            cur.next = pre
            # 两指针往后移
            pre = cur
            cur = tmp

        return pre


"""
再升级：
不定义临时变量，一行搞定交换和指针后移。

cur, pre = head, None
while cur:
    cur.next, pre, cur = pre, cur, cur.next

"""
