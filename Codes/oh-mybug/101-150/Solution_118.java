import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_118
 * Data:        2020/8/5
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。
示例:
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class Solution_118 {
    // DP
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows == 0) return triangle;
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);
            row.add(1);
            for (int j = 1; j < rowNum; j++)
                row.add(prevRow.get(j-1) + prevRow.get(j));
            row.add(1);
            triangle.add(row);
        }

        return triangle;
    }
}
