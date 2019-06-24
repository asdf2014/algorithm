# 思路

本题主要考察对一些逻辑的处理

1. 使用二维数组， 全部默认置""
2. 如果numRows为1， 直接返回s
2. x, y = 0
    - 遍历s, i为下标, 指定一个flag参数， 
    - true的时候y+=1, x不变,  false的时候x+=1， y-=1
    - nums[y][x] = s[i]
    - if y == 0 => flag =True
    - if y == numRows - 1 => flag = False 
      
     
## 代码

```python3
def Solution(s, numRows):
    if numRows == 1:
        return s

    length = len(s)

    chs = [["" for i in range(length)] for i in range(numRows)]

    x, y = 0, 0
    flag = True

    i = 0

    while i < length:

        chs[y][x] = s[i]
        if y == 0:
            flag = True

        if y == numRows - 1:
            flag = False

        if flag:
            y += 1
        else:
            y -= 1
            x += 1

        i += 1

    result = ""
    for row_list in chs:
        for ch in row_list:
            if ch != "":
                result += ch

    return result
```     

## TestCase
```python3
assert Solution("ABC", 1) == "ABC"
assert Solution("PAYPALISHIRING", 4) == "PINALSIGYAHRPI"
```

    