# 思路

1. 递归
    1. 如果pattern为空， 返回not text
    2. 判断是否第一次匹配上了， pattern[0] in {text[0], '.'}
    3. 判断pattern[1] 是否为```*```, 如果是的， 则对text和pattern[2:]进行判断```(匹配0个)```， 
    对text[1:], pattern进行判断```(匹配多个)```.
    4. 对于非特殊字符， 只需要判断text[1:] 后 pattern[1:]    


2. 动态规划

    1. 使用一个词典来储存text, pattern匹配的信息
        1.  匹配的过程与上述递归一致


## 代码

1. 

``` python3
def isMatch(text, pattern):
    
    if not pattern:
        return not text
        
    first_match = bool(text) and pattern[0] in {text[0], '.'}
    
    if len(pattern) >= 2 and pattern[1] == '*':
        return (isMatch(text, pattern[2:]) or 
            first_match and isMatch(text[1:], pattern))
    else:
        return first_match and isMatch(text[1:], pattern[1:])        
```


2. 

```python3
def isMatch(text, pattern):
    memo = {}

    def dp(i, j):
        if (i, j) not in memo:
            if j == len(pattern):
                ans = i == len(text)
            else:
                first_match = i < len(text) and pattern[j] in {text[i], '.'}
                if j + 1 < len(pattern) and pattern[j + 1] == '*':
                    ans = dp(i, j + 2) or first_match and dp(i + 1, j)
                else:
                    ans = first_match and dp(i + 1, j + 1)

            memo[i, j] = ans
        return memo[i, j]

    return dp(0, 0)
```