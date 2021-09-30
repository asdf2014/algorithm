//English description is not available for the problem. Please switch to
//Chinese. Related Topics 数组 二分查找 👍 413 👎 0


#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int minArray(vector<int> &numbers) {
        if (numbers.empty()) {
            return 0;
        }
        for (int i = 0; i < numbers.size() - 1; ++i) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }
};
//leetcode submit region end(Prohibit modification and deletion)

int main() {
    Solution s;
    vector<int> v = vector<int>({3,4,5,1,2});
    cout << s.minArray(v) <<endl;

}