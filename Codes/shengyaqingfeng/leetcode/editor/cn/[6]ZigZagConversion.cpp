// title : [6]ZigZagConversion
// date : 2020-12-12 12:17:09
// author : creazyboyone
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
