# https://leetcode.com/problems/reverse-integer/

# Given a 32-bit signed integer, reverse digits of an integer.
#
# Example 1:
# Input: 123
# Output: 321
#
# Example 2:
# Input: -123
# Output: -321
#
# Example 3:
# Input: 120
# Output: 21
#
# Note:
# Assume we are dealing with an environment which could only store integers
# within the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this problem,
# assume that your function returns 0 when the reversed integer overflows.
#
# Related Topics Math


def reverse_integer(x):
    sign = (x > 0) - (x < 0)
    x *= sign
    size = len(str(x))
    res = 0
    for i in range(1, size + 1):
        remaining = x % 10
        refactor = 10 ** (size - i)
        res += remaining * refactor
        x //= 10
    if res > 2 ** 31 - 1:
        return 0
    return sign * res


assert reverse_integer(123) == 321
assert reverse_integer(-123) == -321
assert reverse_integer(120) == 21
assert reverse_integer(-120) == -21
assert reverse_integer(0) == 0
assert reverse_integer(1534236469) == 0
