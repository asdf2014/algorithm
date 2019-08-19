# 思路

采用递归的做法， 分解每一位， 遇到4, 9便做补1减1的操作.

## Solution

```python3
roman_dict = {
    1: "I",
    5: "V",
    10: "X",
    50: "L",
    100: "C",
    500: "D",
    1000: "M"
}


def solution(num):
    def walk(n, s, level):
        if n == 0:
            return s

        ext = n % 10
        left = int((n - ext) / 10)

        res = convert_ext(ext, level)
        level += 1

        return walk(left, res + s, level)

    s = ""

    return walk(num, s, 0)


def convert_ext(ext, level):
    base = pow(10, level)

    one_char = roman_dict[base]
    five_char = roman_dict.get(base * 5, None)
    ten_char = roman_dict.get(base * 10, None)

    if ext < 4:
        return one_char * ext

    elif ext == 4:
        return one_char + five_char

    elif ext > 4 and ext < 9:
        return one_char * (ext - 5) + five_char

    elif ext == 9:
        return one_char + ten_char

    else:
        return ten_char

```