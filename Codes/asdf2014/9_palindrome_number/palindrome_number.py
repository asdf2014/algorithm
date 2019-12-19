# https://leetcode.com/problems/palindrome-number/

# Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
#
# Example 1:
# Input: 121
# Output: true
#
# Example 2:
# Input: -121
# Output: false
# Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
#
# Example 3:
# Input: 10
# Output: false
# Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
#
# Related Topics Math


def palindrome_number(x):
    return x == 0 or (x > 0) and int(str(x)[::-1]) == x


assert palindrome_number(121)
assert not palindrome_number(-121)
assert not palindrome_number(12)
assert palindrome_number(0)
