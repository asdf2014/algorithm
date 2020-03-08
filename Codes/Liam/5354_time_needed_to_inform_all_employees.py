# 执行用时 : 660 ms
# 内存消耗 : 49.4 MB

# 方案：建图，然后dfs，输出最大时间的叶子节点的值

class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        # 首先根据 [公式] 数组来建图，边权就是父结点到子结点的通知时间
        # 然后从根结点开始做 dfs ，求出根结点到每个叶子结点的路径长度的最大值
        from collections import defaultdict
        dic = defaultdict(list)

        for i in range(n):
            dic[manager[i]].append(i)

        time = [0] * n
            
        def dfs(head, t, time):
            if dic[head]:
                t += informTime[head]
                for child in dic[head]:
                    time[child] = t
                    dfs(child, t, time)
                    
        dfs(headID, 0, time)
        return max(time)
