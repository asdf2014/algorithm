"""
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：

输入: "cbbd"
输出: "bb"

"""

"""
题解: 
本题可以用一种中央扩散法, 最差情况O(N^2)
每次移动一次索引, 就以此为中心扩展判断两边 i-n和i+n是否相同,相同则每次更新一个最大值缓存,不相同时则继续跳到下一个,再重新继续这个步骤
"""


class Solution:
    def longestPalindrome(self, s: str) -> str:
        maxPali = 0
        maxLeft = 0
        maxRight = 1

        total = len(s)

        for oven in range(0, 2):
            for index in range(total - 1):
                left: int = index
                right: int = index + oven
                print(
                    "\n-窗口: "
                    + str(left)
                    + ":"
                    + str(right)
                    + " -> "
                    + s[left]
                    + s[right]
                )

                naborspace = min(index, total - index)
                print("--可用最大邻域: " + str(naborspace + 1))
                for n in range(naborspace + 1):
                    print(
                        "--邻域内比对: 第"
                        + str(n + 1)
                        + "个邻域值，共"
                        + str(naborspace + 1)
                        + "个"
                    )
                    if left >= 0 and right < total:
                        sLeft = s[left]
                        sRight = s[right]
                        if sLeft != sRight:
                            print("--邻域内比对不相同: " + s[left] + " - " + s[right])
                            break
                        print(
                            "----比对到相同对: "
                            + s[left]
                            + s[right]
                            + " 范围: "
                            + s[left : right + 1]
                        )
                        diff = right + 1 - left
                        if diff >= maxPali:
                            maxPali = diff
                            maxLeft = left
                            maxRight = right + 1
                            print(
                                "------更新最大子回文串: "
                                + s[maxLeft:maxRight]
                                + " 范围： "
                                + str(maxLeft)
                                + ","
                                + str(maxRight)
                            )

                        left -= 1
                        right += 1

                print()
        return s[maxLeft:maxRight]


def longestP(s):
    print(s + " 最长回文串 " + Solution().longestPalindrome(s))


# 偶数对称
# longestP("bb")
# longestP("abba")
# longestP("cbbca")

# 奇数对称
# longestP("bbb")
# longestP("cbbbc")
# longestP("abab")
# longestP("babad")
# longestP("abcbaba")
