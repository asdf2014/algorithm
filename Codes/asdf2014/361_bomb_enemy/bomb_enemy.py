# https://leetcode-cn.com/problems/bomb-enemy/

# 想象一下炸弹人游戏，在你面前有一个二维的网格来表示地图，网格中的格子分别被以下三种符号占据：
#
#  'W' 表示一堵墙
#  'E' 表示一个敌人
#  '0'（数字 0）表示一个空位
#
# 请你计算一个炸弹最多能炸多少敌人。
#
# 由于炸弹的威力不足以穿透墙体，炸弹只能炸到同一行和同一列没被墙体挡住的敌人。
#
# 注意：
# 你只能把炸弹放在一个空的格子里
#
# 示例:
# 输入: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
# 输出: 3
# 解释: 对于如下网格
#
# 0 E 0 0
# E 0 W E
# 0 E 0 0
#
# 假如在位置 (1,1) 放置炸弹的话，可以炸到 3 个敌人
#
# Related Topics 动态规划


def bomb_enemy(cells):
    row_len, col_len = len(cells), len(cells[0])
    result = 0
    col_hits = [0] * col_len
    row_hits = 0
    for index_row, row in enumerate(cells):
        for index_cell, cell in enumerate(row):
            if index_cell == 0 or row[index_cell - 1] == "W":
                row_hits = 0
                k = index_cell
                while k < col_len:
                    if row[k] == "W":
                        break
                    row_hits += row[k] == "E"
                    k += 1
            if index_row == 0 or cells[index_row - 1][index_cell] == "W":
                col_hits[index_cell] = 0
                k = index_row
                while k < row_len:
                    if cells[k][index_cell] == "W":
                        break
                    col_hits[index_cell] += cells[k][index_cell] == "E"
                    k += 1
            if cell == "0":
                result = max(result, row_hits + col_hits[index_cell])
    return result


assert (
    bomb_enemy([["0", "E", "0", "0"], ["E", "0", "W", "E"], ["0", "E", "0", "0"]]) == 3
)

assert (
    bomb_enemy([["0", "W", "E", "W"], ["W", "W", "0", "W"], ["0", "W", "E", "W"]]) == 2
)
