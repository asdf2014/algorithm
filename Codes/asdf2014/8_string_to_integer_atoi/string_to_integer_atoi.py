# https://leetcode.com/problems/string-to-integer-atoi/
import re

patten = "^(([+|-]\\d+)|\\d+)"


def string_to_integer_atoi(s):
    match = re.search(patten, s.strip())
    res = int(match.group()) if match else 0
    return max(min(res, 2 ** 31 - 1), -(2 ** 31))


assert string_to_integer_atoi("42") == 42
assert string_to_integer_atoi("-42") == -42
assert string_to_integer_atoi("   -42") == -42
assert string_to_integer_atoi("4193 with words") == 4193
assert string_to_integer_atoi("words and 987") == 0
assert string_to_integer_atoi("91283472332") == 2147483647
assert string_to_integer_atoi("-91283472332") == -2147483648
