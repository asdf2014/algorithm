class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        max_s = ""
        for x in range(len(s)+1):
            for i in range(0,x-len(max_s)):
                if s[i:x] == s[i:x][::-1]:
                    max_s = s[i:x]
        return max_s
