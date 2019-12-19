# https://leetcode.com/problems/regular-expression-matching/

# Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
#
# '.' Matches any single character.
# '*' Matches zero or more of the preceding element.
#
# The matching should cover the entire input string (not partial).
#
# Note:
# s could be empty and contains only lowercase letters a-z.
# p could be empty and contains only lowercase letters a-z, and characters like . or *.
#
#
# Example 1:
# Input:
# s = "aa"
# p = "a"
# Output: false
# Explanation: "a" does not match the entire string "aa".
#
# Example 2:
# Input:
# s = "aa"
# p = "a*"
# Output: true
# Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
#
# Example 3:
# Input:
# s = "ab"
# p = ".*"
# Output: true
# Explanation: ".*" means "zero or more (*) of any character (.)".
#
# Example 4:
# Input:
# s = "aab"
# p = "c*a*b"
# Output: true
# Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
#
# Example 5:
# Input:
# s = "mississippi"
# p = "mis*is*p*."
# Output: false
#
# Related Topics String Dynamic Programming Backtracking


# '.' Matches any single character.
# '*' Matches zero or more of the preceding element.
def regular_expression_matching(s, p):
    # 初始化二维表
    dp = [[False] * (len(s) + 1) for _ in range(len(p) + 1)]
    dp[0][0] = True
    for i in range(1, len(p)):
        dp[i + 1][0] = dp[i - 1][0] and p[i] == "*"
    # i 表示取长度为 i 的 p 字符串
    # j 表示取长度为 j 的 s 字符串
    # dp[i][j] 则表示"取长度为 i 的 p 字符串"可以覆盖"取长度为 j 的 s 字符串"
    for i in range(len(p)):
        for j in range(len(s)):
            # 分不同的情况进行状态转移
            if p[i] == "*":
                dp[i + 1][j + 1] = dp[i - 1][j + 1] or dp[i][j + 1]
                if p[i - 1] == s[j] or p[i - 1] == ".":
                    dp[i + 1][j + 1] |= dp[i + 1][j]
            else:
                dp[i + 1][j + 1] = dp[i][j] and (p[i] == s[j] or p[i] == ".")
    return dp[-1][-1]


assert not regular_expression_matching("a", "")
assert not regular_expression_matching("aa", "a")
assert regular_expression_matching("aa", "a*")
assert regular_expression_matching("ab", ".*")
assert regular_expression_matching("aab", "c*a*b")
assert not regular_expression_matching("mississippi", "mis*is*p*.")
assert regular_expression_matching("yuzhouwan", "y.z...w..")
