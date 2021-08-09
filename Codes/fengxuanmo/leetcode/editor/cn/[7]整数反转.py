# coding:utf-8
# 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
# 
#  如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
# 假设环境不允许存储 64 位整数（有符号或无符号）。
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：x = 123
# 输出：321
#  
# 
#  示例 2： 
# 
#  
# 输入：x = -123
# 输出：-321
#  
# 
#  示例 3： 
# 
#  
# 输入：x = 120
# 输出：21
#  
# 
#  示例 4： 
# 
#  
# 输入：x = 0
# 输出：0
#  
# 
#  
# 
#  提示： 
# 
#  
#  -231 <= x <= 231 - 1 
#  
#  Related Topics 数学 
#  👍 2979 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import sys


class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        INT_MAX = sys.maxsize

        INT_MIN = -sys.maxsize - 1

        num1=str(x)
        s=0
        if x>=0:
            s=num1[::-1]
            s=long(s)
        else:
            s=num1[:0:-1]
            s=long(s)*-1
        if s > (2 ** 31 - 1) or s < -(2 ** 31):
            return 0
        else:
            return s
# leetcode submit region end(Prohibit modification and deletion)
#
# if __name__ == '__main__':
#     s=Solution()
#     m=s.reverse(1563847412)
#     print m