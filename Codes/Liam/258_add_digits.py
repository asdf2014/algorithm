#执行用时 : 24 ms
#内存消耗 : 11.7 MB

#方案：递归

class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        return self.addDigits(sum([int(n) for n in str(num)])) if len(str(num)) != 1 else num
