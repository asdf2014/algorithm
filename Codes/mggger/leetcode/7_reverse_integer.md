# 思路
对输入进行递归， 递归结束条件， 
1. 输入 = 0, 返回输出
2. 递归的过程中如果输出小于-2 ^ 31 或者 大于2^31 - 1, 返回0


## 代码

```python3
def solution(x):
    return -1 * walk(x * -1) if x < 0 else walk(x)


def walk(input, output=0, stage=0):
    if output < pow(-2, 31) or output > pow(2, 31) - 1:
        return 0

    if input == 0:
        return output

    _end = input % 10
    _begin = int((input - _end) / 10)

    return walk(_begin, 10 * output + _end, stage) if stage else walk(_begin, _end, 1)


print(solution(123))
```