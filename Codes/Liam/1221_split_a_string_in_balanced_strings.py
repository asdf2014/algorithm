# 执行用时 : 36 ms
# 内存消耗 : 12.9 MB

# 方案：栈的思想解决，遇到L就把L+1，不是L就是R 就把L-1，当L等于0的时候说明堆栈为空，就把结果+1

class Solution:
    def balancedStringSplit(self, s: str) -> int:
        rst = L = 0 
        for i in s:
            if i == 'L':
                L += 1
            else:
                L -= 1
            if L == 0:
                rst += 1
        return rst
