#执行用时 : 52 ms
#内存消耗 : 11.7 MB

#方案：逆序 对照

class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        return True if str(x) == str(x)[::-1] else False
