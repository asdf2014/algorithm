"""
给定一个 32 位有符号整数，将整数中的数字进行反转。

示例 1:

输入: 123
输出: 321

 示例 2:

输入: -123
输出: -321

示例 3:

输入: 120
输出: 21

注意:

假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。
根据这个假设，如果反转后的整数溢出，则返回 0。
"""

"""
解题思路：
先把符号和数字分开，记录一下符号然后取一下绝对值
然后通过逐位地板除10的方式取出每一位，然后将取出位
再逐位乘以10累加下一次出现的地板除10的结果，这样就可以
倒序乘10再累加。
乘以符号变量后，判断是否在32位有符号整数域中。
"""


class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        # 记住符号位
        sign = 1
        if x != 0:
            sign = x / abs(x)
            # 去掉符号
            x = abs(x)
        # 数字位
        reversedNum = 0
        while x > 0:
            tail = x % 10
            reversedNum = reversedNum * 10 + tail
            x //= 10

        ret = sign * reversedNum
        if reversedNum > 2**31 - 1:
            return 0
        elif reversedNum < -(2**31):
            return 0
        return int(ret)


print(Solution().reverse(-2855524))
