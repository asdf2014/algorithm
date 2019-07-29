# 思路

转成字符串, 判断逆序后是否相等


# 代码

```python3
def isPalindrome(x: int) -> bool:
    return str(x) == str(x)[::-1]
```