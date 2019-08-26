# 思路

字符串映射

## 代码

```python3
def solution(s):
    roman_map = {
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000
    }

    def walk(s, acc=0):
        if not len(s):
            return acc

        if len(s) > 1:
            res = check_special(s[:2])

            if res:
                return walk(s[2:], acc + res)

        return walk(s[1:], acc + roman_map[s[0]])

    return walk(s)


def check_special(spe):
    combine_map = {
        'IV': 4,
        'IX': 9,
        'XL': 40,
        'XC': 90,
        'CD': 400,
        'CM': 900
    }

    res = combine_map.get(spe, 0)
    return res
```