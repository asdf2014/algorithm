## 未成功，稍后继续

class Solution:
    def dfs(self, src, tgt, time, target, dic)->float:
            size = len(dic[src])
            if (not time) or (tgt and size == 1):
                if src == target:
                    return 1
                else:
                    return 0
            p = float(1.0 / (size - 1)) if tgt else float(1.0 / size)
            maxx = 0.0
            
            for i in range(size):
                new_tgt = dic[src][i]
                if new_tgt == tgt:
                    continue
                maxx = max(maxx, self.dfs(new_tgt, src, time-1, target, dic))
            return p * maxx

    def frogPosition(self, n: int, edges: List[List[int]], t: int, target: int):
        # 首先建图，然后从1号结点开始，dfs
        # 每往下走一次，时间t减1。如果t=0或者到了叶子结点了，就判断结点是否为target
        # 是就返回1,不是就返回0。
        # 每次概率除以当前结点的子结点个数，然后再乘上所有子结点dfs结果的最大值（因为结果不是0就是正确概率）
        if n == 1:
            return 1.0

        from collections import defaultdict
        dic = defaultdict(list)

        for sub_list in edges:
            s, t = sub_list[0], sub_list[1]
            dic[s].append(t)
        print(dic)
        return self.dfs(1, 0, t, target, dic)
