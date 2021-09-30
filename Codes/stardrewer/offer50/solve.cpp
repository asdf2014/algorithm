//English description is not available for the problem. Please switch to
//Chinese. Related Topics 队列 哈希表 字符串 计数 👍 141 👎 0


#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    char firstUniqChar(string s) {
        unordered_map<int, int> cache;
        for (char ch : s) {
            cache[ch]++;
        }
        for (int i = 0; i < s.size(); ++i) {
            if (cache[s[i]] == 1) {
                return s[i];
            }
        }
        return ' ';
    }
};
//leetcode submit region end(Prohibit modification and deletion)

int main() {
    Solution s;

    cout << s.firstUniqChar("leetcode") << endl;
}