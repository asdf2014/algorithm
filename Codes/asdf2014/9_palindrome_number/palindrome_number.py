# https://leetcode.com/problems/palindrome-number/


def palindrome_number(x):
    return x == 0 or (x > 0) - (x < 0) == 1 and int(str(x)[::-1]) == x


assert palindrome_number(121)
assert not palindrome_number(-121)
assert not palindrome_number(12)
assert palindrome_number(0)
