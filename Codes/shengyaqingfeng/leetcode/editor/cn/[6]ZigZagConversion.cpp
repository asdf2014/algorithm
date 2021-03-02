// title : [6]ZigZagConversion
// date : 2020-12-12 12:17:09
// author : creazyboyone
// note :
// 思路1：开数组依次保存和输出. (节省时间,消耗内存)
// 思路2: 多次循环, 每次计算好位置 push_back "一行". (节省内存,消耗时间)

#include <iostream>
#include <string>
#include <vector>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        string res;
        int cycle = (numRows - 1) * 2;
        vector <string> v(numRows, string());
        for (int i = 0; i < s.size(); i++) {
            int col = i % cycle;
            col = col < numRows ? col : numRows * 2 - col - 2;
            v[col].push_back(s[i]);
        }
        for (int i = 0; i < numRows; i++) {
            res += v[i];
        }
        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
