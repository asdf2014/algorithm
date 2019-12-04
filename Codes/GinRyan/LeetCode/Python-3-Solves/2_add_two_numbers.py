"""
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807


"""

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        retListNode: ListNode = ListNode(None)

        latestRetListNode = retListNode

        currentNode1 = l1
        currentNode2 = l2
        # 满位进制准备值
        carry = 0

        while currentNode1 != None or currentNode2 != None:
            # 一旦遇到单个空节点，则说明高位为0，则填充高位为0
            if currentNode1 is None:
                currentNode1 = ListNode(0)
            if currentNode2 is None:
                currentNode2 = ListNode(0)
            print(str(currentNode1.val) + "  " + str(currentNode2.val))

            # 新建一个节点，并且填充两数字之和，并且加上上一节点进位值。如无进位这个值为0
            csum = currentNode1.val + currentNode2.val + carry
            # 取余做填充数值
            cmod = csum % 10
            # 取整除值做进位值写入到to_upper_pos变量中，用于下次将进位值加和
            carry = csum // 10

            createNode = ListNode(cmod)

            # 挂接到结果链表节点下
            latestRetListNode.next = createNode
            # 挂接到结果链表节点下之后还要向前推latestRetListNode到下一个节点
            latestRetListNode = latestRetListNode.next

            # 次级节点递送
            currentNode1 = currentNode1.next
            currentNode2 = currentNode2.next
        # 最高位如果升位，需要增加一位节点，放1
        if carry > 0:
            createNode = ListNode(carry)
            latestRetListNode.next = createNode

        return retListNode.next


# 测试代码
s = Solution()

l11 = ListNode(5)
l12 = ListNode(4)
l13 = ListNode(6)

l21 = ListNode(5)
l22 = ListNode(6)
l23 = ListNode(4)


l11.next = l12
l12.next = l13

l21.next = l22
l22.next = l23

# 不同位长度的整数相加
# l24 = ListNode(7)
# l23.next = l24

ret = s.addTwoNumbers(l11, l21)
print("result: ")
while ret != None:
    print(ret.val)
    ret = ret.next

