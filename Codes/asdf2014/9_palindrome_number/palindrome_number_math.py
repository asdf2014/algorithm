# https://leetcode.com/problems/palindrome-number/


def palindrome_number(x):
    if x < 0:
        return False
    elif x == 0:
        return True
    h, rev = x, 0
    while h:
        rev = rev * 10 + h % 10
        h //= 10
    return rev == x


assert palindrome_number(121)
assert not palindrome_number(-121)
assert not palindrome_number(12)
assert palindrome_number(0)
