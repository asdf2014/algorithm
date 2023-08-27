// title : [16]ThreeSumClosest
// date : 2023-08-27 11:58:09
// author : creazyboyone
// note : 和上一题类似，小于0条件去掉, 条件改为 j < k 扫完，取 sum 最接近 target. 依然超时。
// 主要是把小于0条件去掉了，如果加回来，变成小于target条件去掉呢？剪了，还不行
// 过滤重复也做了，还是超时
// 可能需要分三种情况了。 target 远小于数组，target 远小于数组，target 在数组范围内
// 这样就不能全部都从外到内了。过大或者过小直接暴搜，暴搜还是会爆
// target - i ==> j + k
// wc 看了下题解发现思路和自己一样，心想不对啊。结果去掉cout就过了。真极限！

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());
        int num = (int) nums.size();
        int res = nums[0] + nums[1] + nums[2];
        // 如果 target 在 数组范围内可以剪枝
        for (int i = 0; i < num; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = num - 1;
            while (j < k) {
                while (j < k - 2 && nums[k] == nums[k - 1]) {
                    k--;
                }
                while (j + 2 < k && nums[j] == nums[j + 1]) {
                    j++;
                }
                int sum = nums[i] + nums[j] + nums[k];
//                cout << nums[i] << " " << nums[j] << " " << nums[k] << " " << sum << " " << abs(sum - target) << endl;
                res = abs(sum - target) < abs(res - target) ? sum : res;
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)