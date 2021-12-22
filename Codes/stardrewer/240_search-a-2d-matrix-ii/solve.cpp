//Write an efficient algorithm that searches for a target value in an m x n
//integer matrix. The matrix has the following properties:
//
//
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
//
//
//
// Example 1:
//
//
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 5
//Output: true
//
//
// Example 2:
//
//
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 20
//Output: false
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= n, m <= 300
// -10⁹ <= matrix[i][j] <= 10⁹
// All the integers in each row are sorted in ascending order.
// All the integers in each column are sorted in ascending order.
// -10⁹ <= target <= 10⁹
//
// Related Topics 数组 二分查找 分治 矩阵 👍 735 👎 0


#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        if (m == 0 && n == 0) {
            return false;
        }
        for (int i = 0, j = n - 1; i < m && j >= 0;) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) i++;
            else if (matrix[i][j] > target) j--;
        }
        return false;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

int main() {
    Solution s;

    vector<vector<int>> A;
    vector<int> B;
    B.push_back(1);
    B.push_back(2);
    A.push_back(B);
    B.clear();
    B.push_back(3);
    B.push_back(5);
    A.push_back(B);

    std::cout << s.searchMatrix(A, 5) << endl;
}