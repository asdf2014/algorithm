// title : [8]StringToInteger(atoi)
// date : 2020-12-12 20:50:59
// author : creazyboyone
// note : 被卡住的点：
// "21474836460" (没算好位数)
// "00000-42a1234" (没想到会有0在负号前面这种情况)


#include <iostream>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int myAtoi(string s) {
        bool positive = true;
        if (s.empty()) {
            return 0;
        }
        const char *p = s.c_str();
        const char *q;
        while (p[0] == ' ')
            p++;
        if (p[0] == '+') {
            positive = true;
            p++;
        } else if (p[0] == '-') {
            positive = false;
            p++;
        }
        while (p[0] == '0')
            p++;
        // 起点是p ,终点是q
        if (p[0] > '0' && p[0] <= '9') {
            q = p;
            while (q[0] >= '0' && q[0] <= '9') {
                q++;
            }
            // 简单排除下
            cout << q - p;
            if (q - p > 10) {
                if (positive) {
                    return 2147483647;
                } else {
                    return -2147483648;
                }
            }
            long total = 0;
            // 正式处理
            while (p != q) {
                int a = p[0] - 48;
                total = total * 10 + a;
                p++;
            }
            total = positive ? total : -total;
            if (total > 2147483647) {
                return 2147483647;
            } else if (total < -2147483648) {
                return -2147483648;
            } else {
                return total;
            }
        } else {
            return 0;
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
