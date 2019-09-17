def isPalindrome(x):
    """
    :type x: int
    :rtype: bool
    """
    if x < 0:
        return False
    else:

        s = str(x)
        print s[::0]
        for i, j in enumerate(s):
            if i >= len(s) / 2:
                return True
            else:
                if j != s[len(s) - i - 1]:
                    return False


class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        else:
            y = str(x)[::-1]
            if y == str(x):
                return True
            else:
                return False
