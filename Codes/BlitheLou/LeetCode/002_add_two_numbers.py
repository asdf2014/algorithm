"""
1. 两数相加

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照
 逆序的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
"""
"""
方式一：
由于 输入：(2 -> 4 -> 3) 表示整数 342.
这里链表是逆序存储的，我们可以利用先进后出的栈结构，来存取一遍。
所以，可以将数字从链表依次取出，放入栈结构，再从栈取出并组合，即为链表表示的整数。
    再求和之后，把结果转化为链表返回。


方式二：
增加一个变量 n 表示整数位. 
依次取出链表中的数字，按照顺序求出该位数字 对应到最后整数的实际值。
    再求和之后，把结果转化为链表返回。

举例 输入：(2 -> 4 -> 3) 表示整数 342.
    那么：取出2时，n=0.  对应 (2 = 2*10^0)
    取出4时，n=1.  对应 (40 = 4*10^1)
    取出3时, n=2. 对应 (300 = 3*10^2)
    再相加得整数：2+40+300 = 342
    
可推导出：取出的第i个数字对应的实际值，再求和得最终的整数。
（公式可看图片 ../images/002_add_two_numbers.png）


方式三：
从两个链表依次取出数字，分别对应 个十百千...位，直接把对应位相加，
    若有进位，则链表下一次取出的数字加一。
    这样取出并求和得到的结果，正好又可以存放到结果链表中，来表示它们的和。
    

总结：
    方式一二：可以由题目示例容易想到，但是转化流程较繁琐。
            (链表 -> 整数 -> 整体求和 -> 链表)
    方式三：可以边取数，边计算，边存到结果链表。
            (节点 -> 整数位 -> 求和 -> 节点 -> 链表)

另外也可以递归求解。

"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        result_list_node: ListNode = ListNode(0)
        tmp: ListNode = result_list_node
        carry: int = 0

        while l1 or l2 or carry:
            # 相同位相加
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            total = val1 + val2 + carry

            # 确定进位和链表下一位的值
            carry = total // 10
            next_node = total % 10
            tmp.next = ListNode(next_node)
            tmp = tmp.next

            l1 = l1.next if l1 else l1
            l2 = l2.next if l2 else l2

        return result_list_node.next
