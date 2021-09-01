# coding:utf-8
# 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
# 功能。(若队列中没有元素，deleteHead 操作返回 -1 )
#
#
#
#  示例 1：
#
#  输入：
# ["CQueue","appendTail","deleteHead","deleteHead"]
# [[],[3],[],[]]
# 输出：[null,null,3,-1]
#
#
#  示例 2：
#
#  输入：
# ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
# [[],[],[5],[2],[],[]]
# 输出：[null,-1,null,null,5,2]
#
#
#  提示：
#
#
#  1 <= values <= 10000
#  最多会对 appendTail、deleteHead 进行 10000 次调用
#
#  Related Topics 栈 设计 队列
#  👍 296 👎 0


# leetcode submit region begin(Prohibit modification and deletion)


class CQueue(object):
    def __init__(self):
        self.s1 = []
        self.s2 = []

    def appendTail(self, value):
        """
        :type value: int
        :rtype: None
        """
        if value is None:
            pass
        else:
            self.s1.append(value)

    def deleteHead(self):
        """
        :rtype: int
        """
        if len(self.s2) == 0:
            if self.s1:
                while self.s1:
                    self.s2.append(self.s1.pop())
            else:
                return -1
        return self.s2.pop()


# Your CQueue object will be instantiated and called as such:
# obj = CQueue()
#
# obj.appendTail(3)
# print obj.deleteHead()
# print obj.deleteHead()
# print obj.deleteHead()
# obj.appendTail(13)
# obj.appendTail(14)
# print obj.deleteHead()
# print obj.deleteHead()
# obj.appendTail(12)

# print obj.deleteHead()
# leetcode submit region end(Prohibit modification and deletion)

# if __name__ == '__main__':
#     l=[]
#     l.pop()
