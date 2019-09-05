数字转换
```python
class Solution:
    def myAtoi(self, str: str):
        str = str.strip()
        if len(str) == 0:
            return 0
        i = 0
        sign = 1
        if str[i] == '+':
            i += 1
        elif str[i] == '-':
            i += 1
            sign = -1

        int_max = 2 ** 31 - 1
        int_min = -2 ** 31
        num = 0
        for c in str[i:]:
            if '0' <= c <= '9':
                digit = int(c)
            else:
                break

            if num > int_max // 10 or (num == int_max // 10 and digit > int_max % 10):
                return int_max if sign == 1 else int_min

            num = num * 10 + digit
        return sign * num
```