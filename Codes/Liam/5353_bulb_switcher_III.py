# 执行用时：124 ms
# 内存消耗：18.9 MB

# 方案：所有的亮灯都连续排列在数组最左边，没有间断； 那么本题目转化为：判断 当前时刻亮灯的最大编号 是否 等于亮灯的数量


class Solution:
    def numTimesAllBlue(self, light: List[int]) -> int:
        # 所有的亮灯都连续排列在数组最左边，没有间断
        # 判断 当前时刻亮灯的最大编号 是否 等于亮灯的数量
        rst, maxx = 0, 0
        for idx, on_light in enumerate(light):
            maxx = max(maxx, on_light)
            if maxx == idx + 1:
                rst += 1
        return rst
