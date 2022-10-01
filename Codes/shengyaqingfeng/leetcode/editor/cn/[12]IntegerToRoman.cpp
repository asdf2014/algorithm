// title : [12]IntegerToRoman
// date : 2022-10-01 04:33:54
// author : creazyboyone
// note : 还行吧, 本来是找零钱问题? 346 = (100 + 100 + 100) + (50 - 10) + (5 + 1)
// 被我硬生生玩成了找规律hhh


#include <iostream>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    char role[7] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    string result;

    void printRoman(int level, int num) {
        if (num == 4) {
            level--;
            result.push_back(role[level * 2]);
            result.push_back(role[level * 2 + 1]);
        } else if (num == 9) {
            result.push_back(role[(level - 1) * 2]);
            result.push_back(role[level * 2]);
        } else {
            if (num > 4) {
                num -= 5;
                result.push_back(role[level * 2 - 1]);
            }
            for (int i = 0; i < num; i++) {
                result.push_back(role[(level - 1) * 2]);
            }
        }
    }

    string intToRoman(int num) {
        int arr[4] = {num / 1000, (num / 100) % 10, (num % 100) / 10, num % 10};
        int len = sizeof(arr) / sizeof(arr[0]);
        for (int i = 0; i < len; i++) {
            if (arr[i] > 0) {
                printRoman(len - i, arr[i]);
            }
        }
        return result;
    }
};
//leetcode submit region end(Prohibit modification and deletion)