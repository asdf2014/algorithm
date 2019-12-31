class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        g = int(str(x)[::-1]) if x>=0 else -int(str(x)[1:][::-1])
        if g< - 2147483648 or g > 2147483648-1:
            return 0
        return g
