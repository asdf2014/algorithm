"""
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true

示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

进阶:

你能不将整数转为字符串来解决这个问题吗？
"""
"""
解题思路：

还是转换成字符串简单一点。
头尾对称方式找i对应的位置len - i - 1 ，看是否相同，
当一次循环下来找到不同值的那么这个数就不是回文数。

"""


# 0 1 2
# 0 1 0
# 0 1 2 3
# 0 1 1 0
class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        xstr = str(x)
        xlen = len(xstr)
        midposition = xlen // 2
        index = 0
        while index < midposition:
            eq = xstr[index] == xstr[xlen - index - 1]
            if not eq:
                return False
            index += 1
        return True


print(Solution().isPalindrome(13455431))
