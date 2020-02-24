# 执行用时 : 160 ms
# 内存消耗 : 13.2 MB

# 方案：挨个遍历 看看是否它的double也在数组


class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        n = len(arr)
        for i in range(n):
            for j in range(n):
                if i != j and arr[i] * 2 == arr[j]:
                    return True
        return False
