# 思路

滑动窗口算法 使用数据结构set

1. 令i, j， ans = 0
2. 将s[j] 添加到set中
    - set没有包含s[j], j++， ans = (j - i) if (j - i) > ans else ans
    - set包含s[j], set 删除s[i], i += 1
3. ans就是最大子串的长度


## Code

```python
def solution(s):
    ans = i = j = 0 
    ss = set()
    length = len(s)

    while i < length and j < length:
        if s[j] in ss:
            ss.remove(s[i])
            i += 1
        else:
            ss.add(s[j])
            j+=1 
            ans = (j - i) if (j - i) > ans else ans 

    return ans
```