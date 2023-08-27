// title : [17]LetterCombinationsOfAPhoneNumber
// date : 2023-08-27 15:04:39
// author : creazyboyone
// note : 看起来是水题，先遍历看看。
// 想了挺久。好像做不了遍历，要嵌套遍历。而且嵌套层数是根据输入位数。
// 看看做递归试试，来一个2，转abc存着。来一个3，新起一个新数组大小3^2.每个重新组合
// 可以通过样例，直接提交！爆内存！terminate called after throwing an instance of 'std::bad_alloc'
// 没理由爆内存呀 234 1+3+9+27=41vector。调试下
// 晕，index搞错了，执行耗时:0 ms,击败了100.00% 的C++用户 ：)

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<string> nextDig(vector<string> &a, string &b) {
        // 开数组
        size_t scale = a.size() * b.size();
        vector<string> newArray(scale);
        // 遍历填数组
        for (int i = 0; i < a.size(); ++i) {
            for (int j = 0; j < b.size(); ++j) {
                newArray[i * b.size() + j].append(a[i]).append(b.substr(j, 1));
            }
        }
        return newArray;
    }

    vector<string> letterCombinations(string digits) {
        size_t d_size = digits.size();
        vector<string> dig = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        vector<string> s{""};
        for (int i = 0; i < d_size; ++i) {
            string ac = dig[(int)digits[i] - 50];
            // 开始遍历
            s = nextDig(s, ac);
        }
        if (s.size() == 1) {
            s.pop_back();
        }
        return s;
    }
};
//leetcode submit region end(Prohibit modification and deletion)