// title : [13]RomanToInteger
// date : 2022-10-01 15:29:52
// author : creazyboyone
// note : 上一题的反转，每次读两个字符，不匹配就读1个字符。


#include <iostream>
#include <cmath>
using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

public:
    string arr[6] = {"IV", "XL", "CD", "IX", "XC", "CM"};
    char pp[7] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    int num[7] = {1, 5, 10, 50, 100, 500, 1000};
    int arr_len = sizeof(arr)/ sizeof(arr[0]);

    int romanToInt(string s) {
        int index = 0;
        int result = 0;
        for (; index < s.length();) {
            string tmp = s.substr(index, 2);
            bool flag = false;
            for (int i = 0; i < arr_len; ++i) {
                if (arr[i] == tmp) {
                    result += ((i < 3) ? 4 : 9) * pow(10, i % 3);
                    index += 2;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            // 匹配不上,再去匹配单字符的
            for (int i = 0; i < sizeof(pp); ++i) {
                if (pp[i] == s[index]) {
                    result += num[i];
                    index += 1;
                    break;
                }
            }
        }
        return result;
    }
};
//leetcode submit region end(Prohibit modification and deletion)