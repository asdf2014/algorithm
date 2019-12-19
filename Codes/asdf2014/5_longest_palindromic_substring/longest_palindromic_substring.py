# https://leetcode.com/problems/longest-palindromic-substring/

# Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
#
# Example 1:
# Input: "babad"
# Output: "bab"
# Note: "aba" is also a valid answer.
#
#
# Example 2:
# Input: "cbbd"
# Output: "bb"
#
# Related Topics String Dynamic Programming


def longest_palindromic_substring(s):
    res = ""
    for i in range(len(s)):
        odd = find(s, i, i)
        even = find(s, i, i + 1)
        res = max(res, odd, even, key=len)
    return res


def find(s, left, right):
    while left >= 0 and right < len(s) and s[left] == s[right]:
        left -= 1
        right += 1
    return s[left + 1 : right]


assert longest_palindromic_substring("babad") == "bab"
assert longest_palindromic_substring("cbbd") == "bb"
assert longest_palindromic_substring("yuzhouwan.com") == "y"
