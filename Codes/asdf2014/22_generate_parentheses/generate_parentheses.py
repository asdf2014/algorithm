# https://leetcode.com/problems/generate-parentheses/

# Given n pairs of parentheses, write a function to generate all combinations of
# well-formed parentheses.
#
# For example, given n = 3, a solution set is:
# [
#  "((()))",
#  "(()())",
#  "(())()",
#  "()(())",
#  "()()()"
# ]
#
# Related Topics String Backtracking


def generate_parentheses(n: int) -> [str]:
    if n <= 0:
        return []
    res = [[None], ["()"]]
    for i in range(2, n + 1):
        tmp = []
        for j in range(i):
            tmp1 = res[j]
            tmp2 = res[i - j - 1]
            for t1 in tmp1:
                for t2 in tmp2:
                    if t1 is None:
                        t1 = ""
                    if t2 is None:
                        t2 = ""
                    tmp.append("(" + t1 + ")" + t2)
        res.append(tmp)
    return res[n]


assert generate_parentheses(-1) == []
assert generate_parentheses(0) == []
assert generate_parentheses(3) == ["()()()", "()(())", "(())()", "(()())", "((()))"]
