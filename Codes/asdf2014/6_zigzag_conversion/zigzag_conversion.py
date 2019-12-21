# https://leetcode.com/problems/zigzag-conversion/


# The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
# (you may want to display this pattern in a fixed font for better legibility)
#
#
# P   A   H   N
# A P L S I I G
# Y   I   R
#
#
# And then read line by line: "PAHNAPLSIIGYIR"
#
# Write the code that will take a string and make this conversion given a number of rows:
# string convert(string s, int numRows);
#
# Example 1:
# Input: s = "PAYPALISHIRING", numRows = 3
# Output: "PAHNAPLSIIGYIR"
#
# Example 2:
# Input: s = "PAYPALISHIRING", numRows = 4
# Output: "PINALSIGYAHRPI"
# Explanation:
#
# P     I     N
# A   L S   I G
# Y A   H R
# P     I
#
# Related Topics String


# P     I     N
# A   L S   I G
# Y A   H R
# P     I

# 0,1,2,3  4,5  6,7,8,9  10,11  12,13,14,15


def zigzag_conversion(s, num_rows):
    s_len = len(s)
    if s_len == 0 or num_rows <= 0:
        return ""
    if s_len < 3 or num_rows == 1:
        return s
    middle_num = num_rows - 2
    cycle_num = num_rows + middle_num
    remain = s_len % cycle_num
    x_total = (s_len // cycle_num) * (middle_num + 1)
    if 0 < remain <= num_rows:
        x_total += 1
    elif remain > num_rows:
        x_total += remain - num_rows + 1
    arr = [["" for _ in range(x_total)] for _ in range(num_rows)]
    count = 0
    for c in s:
        cycle_times = count // cycle_num
        remain = count % cycle_num
        if remain < num_rows:
            arr[remain][cycle_times * (middle_num + 1)] = c
        else:
            arr[num_rows - (remain - (num_rows - 1)) - 1][
                cycle_times * (middle_num + 1) + remain - num_rows + 1
            ] = c
        count += 1
    return "".join(str(x) for inner_arr in arr for x in inner_arr)


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
