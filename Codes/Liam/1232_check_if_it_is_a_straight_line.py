# 执行用时 : 72 ms
# 内存消耗 : 13.3 MB

# 方案：两点确定一条线 的公式

class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        if len(coordinates) == 1 or len(coordinates) == 2:
            return True
        if len(coordinates) >= 3:

            def func(p):
                x1, y1 = coordinates[0][0], coordinates[0][1]
                x2, y2 = coordinates[1][0], coordinates[1][1]
                x, y = p[0], p[1]
                if (y - y1)*(x2 - x1) == (x - x1)*(y2 - y1):
                    return True
                else:
                    return False

            flag = [True, True]
            for p in coordinates[2:]:
                flag.append(func(p))
        
        return False if False in flag else True
