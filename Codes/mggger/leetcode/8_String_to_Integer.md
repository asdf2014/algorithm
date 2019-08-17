# 思路
本题主要考的一些逻辑判断， 很无聊。

# 代码
```python3
def solution(s):
    nonspace = str.strip()
    negative = False
    firstPredict = True
    isNumber = False

    tmp = 0

    for i in nonspace:
        if firstPredict:
            if i == '-':
                firstPredict = False
                negative = True
                continue

            if i == '+':
                firstPredict = False
                negative = False
                continue

        if i >= '0' and i <= '9':
            firstPredict = False
            isNumber = True
            tmp = tmp * 10 + int(i)
        else:
            break

    if isNumber:
        if negative:
            return pow(-2, 31) if tmp * -1 < pow(-2, 31) else tmp * -1
        else:
            return pow(2, 31) - 1 if tmp > pow(2, 31) -1 else tmp

    return 0
```