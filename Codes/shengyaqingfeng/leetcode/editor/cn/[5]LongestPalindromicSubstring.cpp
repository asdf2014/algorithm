//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters (lower-case and/or upper-case), 
//
// 
// Related Topics 字符串 动态规划 
// 👍 2981 👎 0

// 复习了一遍线性动态规划, 了解了马拉车算法
// 还是太久没刷题了，思维太不活跃了，或者是太依赖调试了，突然不能调试适应不过来
// 调了半天的中心扩散法, 一直过不去 Time Limit Exceeded
// 以为是算法有问题, 跑去贴别人的代码通过了, 想想不会差别那么大的
// 最后发现是调试的三个输出语句导致超时了, leetcode 时间卡的真严格
#include <string>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    string longestPalindrome(string s) {
        int len = s.size();
        if (len < 2) {
            return s;
        }
        int max = 0;
        int start = 0, end = 0;
        for (int i = 0; i < len - 1; i++) {
            // 奇数
            int a = i, b = i;
            while (a >= 0 && b < len && s[a] == s[b]) {
//                cout << i << " " << a << " " << b << endl;
                a--;
                b++;
            }
            // 偶数
            int x = i, y = i + 1;
            while (x >= 0 && y < len && s[x] == s[y]) {
//                cout << i << " " << x << " " << y << endl;
                x--;
                y++;
            }
            if (b - a > y - x && b - a > max) {
                max = b - a;
                start = a + 1;
                end = b;
            } else if (y - x > max) {
                max = y - x;
                start = x + 1;
                end = y;
            }
        }
//        cout << start << " " << end;
        return s.substr(start, end - start);
    }

    string other(string s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        string res = s.substr(0, 1);
        for (int i = 0; i < len - 1; i++) {
            string oddStr = centerSpread(s, i, i);
            string evenStr = centerSpread(s, i, i + 1);
            string maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    string centerSpread(string s, int left, int right) {
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s[i] == s[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substr(i + 1, j - i - 1);
    }
};
//leetcode submit region end(Prohibit modification and deletion)
