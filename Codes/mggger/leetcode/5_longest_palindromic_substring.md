# 思路

动态规划求解， 运用一个数据结构matrix存储s[i][j]是否为回文子串

1. 遍历字符串s， l为s的长度
2. l如果小于2返回s
3. 令i = l - 1， j = i， i递减（下限为0)， j递增(上限为l-1)
    - i == j 则 matrix[i][j] = True  
    - i != j, matrix[i][j] = (s[i] == s[j] && matrix[i+1][j-1])
    
4. ii, ij, longest分别最长回文子串的索引和长度 

## 代码

```python3
def solution(s):
    l = len(s)
    matrix = [[False for i in range(l)]
              for j in range(l)
              ]

    ii, ij, longest = 0, 0, 0

    for i in range(l - 1, -1, -1):
        for j in range(i, l):

            if i == j or (s[i] == s[j] and ((j - i < 2) or matrix[i + 1][j - 1])):

                matrix[i][j] = True

                if longest < j - i:
                    longest = j - i
                    ii = i
                    ij = j

    return s[ii: ij+1]
```

## TestCase
```python3
assert solution("ababa") == 'ababa'
```
