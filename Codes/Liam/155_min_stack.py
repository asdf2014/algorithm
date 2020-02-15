# 执行用时 : 1036 ms
# 内存消耗 : 16.8 MB

# 方案：用list解决出栈入栈和删除

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.L = []

    def push(self, x: int) -> None:
        if x is not None:
            self.L.append(x)

    def pop(self) -> None:
        if self.L is not None:
            self.L.pop(-1)

    def top(self) -> int:
        if self.L is not None:
            return self.L[-1]

    def getMin(self) -> int:
        if self.L is not None:
            return min(self.L)
        

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
