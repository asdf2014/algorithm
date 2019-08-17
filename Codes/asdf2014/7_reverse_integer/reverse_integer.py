# https://leetcode.com/problems/reverse-integer/


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
