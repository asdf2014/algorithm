# 执行用时 : 60 ms
# 内存消耗 : 15 MB

# 方案：排列组合性质 C(m,n)=C(m-1,n)+C(m-1,n-1)


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        # 排列组合性质 C(m,n)=C(m-1,n)+C(m-1,n-1)
        if k > n or k == 0:
            return []
        if k == 1:
            return [[i] for i in range(1, n + 1)]
        if k == n:
            return [[i for i in range(1, n + 1)]]

        answer = self.combine(n - 1, k)
        for item in self.combine(n - 1, k - 1):
            item.append(n)
            answer.append(item)

        return answer
