# https://leetcode.com/problems/regular-expression-matching/


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
