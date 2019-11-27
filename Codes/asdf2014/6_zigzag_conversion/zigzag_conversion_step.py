# https://leetcode.com/problems/zigzag-conversion/


# 理解为 x, y 轴两个方向上爬格子，某一个方向上达到 num_rows 步数上限之后，则换一个方向继续爬格子，以此类推
def zigzag_conversion(s, num_rows):
    if num_rows == 1 or num_rows >= len(s):
        return s
    res = [''] * num_rows
    index, step = 0, 1

    for c in s:
        res[index] += c
        if index == 0:
            step = 1
        elif index == num_rows - 1:
            step = -1
        index += step

    return ''.join(res)


assert zigzag_conversion("", 0) == ""
assert zigzag_conversion("", 1) == ""
assert zigzag_conversion("A", 1) == "A"
assert zigzag_conversion("AB", 1) == "AB"
assert zigzag_conversion("AB", 2) == "AB"
assert zigzag_conversion("ABC", 1) == "ABC"
assert zigzag_conversion("ABC", 2) == "ACB"
assert zigzag_conversion("ABCD", 2) == "ACBD"
assert zigzag_conversion("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR"
assert zigzag_conversion("PAYPALISHIRING", 4) == "PINALSIGYAHRPI"
assert zigzag_conversion("YHAONOUU.MCWZ", 4) == "YUZHOUWAN.COM"
