# https://leetcode.com/problems/add-two-numbers/


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def add_two_numbers(left, right):
    # 记录进数
    carry = 0
    tmp = ListNode(0)
    root = tmp
    while left or right:
        # 当前层级两节点的值，加上低层级的进位
        total = carry + left.val + right.val
        # 循环到更高层级
        left = left.next
        right = right.next
        # 计算进数
        carry = total // 10
        # 余数作为当前层级的计算结果
        tmp.next = ListNode(total % 10)
        # 将临时节点当做游标，用于暂存更高层级的节点
        tmp = tmp.next
    return root.next


n1 = ListNode(2)
n1.next = ListNode(4)
n1.next.next = ListNode(3)

n2 = ListNode(5)
n2.next = ListNode(6)
n2.next.next = ListNode(4)

res = ListNode(7)
res.next = ListNode(0)
res.next.next = ListNode(8)


def check(left, right):
    while left or right:
        if left and not right or not left and right:
            return False
        if left.val != right.val:
            return False
        left = left.next
        right = right.next
    return True


assert not check(n1, n2)
assert check(add_two_numbers(n1, n2), res)
