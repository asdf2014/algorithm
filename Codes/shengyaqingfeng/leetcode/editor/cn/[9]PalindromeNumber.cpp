// title : [9]PalindromeNumber
// date : 2020-12-12 22:25:19
// author : creazyboyone
// note : 水题, 要先转字符串再判断, 字符串长度要满足整数无符号int的范围


#include <iostream>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        char p[32];
        sprintf(p, "%d", x);
        int len = strlen(p);
        for (int i = 0; i < len / 2; i++) {
            if (p[i] != p[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
