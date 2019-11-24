#超时

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        # 动态规划
        # 方案：延伸
        # 1. 如果一个字符串是回文串，那么在它左右分别加上一个相同的字符，那么它一定还是一个回文串
        # 2. 如果一个字符串不是回文串，或者在回文串左右分别加不同的字符，得到的一定不是回文串
        # if (s[i] === s[j] && dp[i + 1][j - 1]):
        #     dp[i][j] = true
        
        if len(s) == 0:
            return ""
        
        result = s[0]
        dp = [[False] * len(s)] * len(s)

        #倒着遍历简化操作
        for i in range(len(s))[::-1]:
            dp[i] = [False] * len(s)
            for j in range(i,len(s)):
                if j - i == 0:
                    dp[i][j] = True
                elif (j - i == 1) and (s[i] == s[j]):
                    dp[i][j] = True
                elif (s[i] == s[j] and dp[i + 1][j - 1]):
                    #state transition
                    dp[i][j] = True
                if (dp[i][j] and j - i + 1 > len(result)):
                    #update result
                    result = s[i : j + 1]
        return result
