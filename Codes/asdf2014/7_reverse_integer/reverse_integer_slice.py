# https://leetcode.com/problems/reverse-integer/


def reverse_integer(x):
    sign = (x > 0) - (x < 0)
    res = int(str(x * sign)[::-1])
    return sign * res * (res < 2**31)


assert reverse_integer(123) == 321
assert reverse_integer(-123) == -321
assert reverse_integer(120) == 21
assert reverse_integer(-120) == -21
assert reverse_integer(0) == 0
assert reverse_integer(1534236469) == 0
