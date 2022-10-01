// title : [14]LongestCommonPrefix
// date : 2022-10-01 17:37:47
// author : creazyboyone
// note : 经典算法入门题，但是几年没刷题了，全忘光光了。想到什么写什么呗
// 因为要找最大公共子串，所以一定要满足所有字符串都有那串。所以随便拿出一个来substring一定能找到一个，其他都有的，不然返回空
// 因为要最长，所以优先substring s.size()然后不对再长度减1，直到匹配上
// 先找出最短的字符串拿来匹配，可以减少计算量，先试试把
// 看错了，是最大公共前缀，那就简单了，水题


#include <iostream>
#include <vector>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool flag = true;

    static int findSmallestStr(vector<string> &s) {
        int small = 201;
        for (const string &str : s) {
            int len = str.length() > 201 ? 201 : (int) str.length();
            small = small < len ? small : len;
        }
        return small;
    }

    string longestCommonPrefix(vector<string> &strs) {
        int len = findSmallestStr(strs);
        int i = 0;
        for (; i < len; ++i) {
            char ver = strs[0][i];
            for (int j = 1; j < strs.size(); ++j) {
                if (strs[j][i] != ver) {
                    // 匹配不上
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        return strs[0].substr(0, i);
    }
};
//leetcode submit region end(Prohibit modification and deletion)
