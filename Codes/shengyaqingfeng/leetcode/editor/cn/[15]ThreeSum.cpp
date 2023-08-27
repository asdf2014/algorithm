// title : [15]ThreeSum
// date : 2022-10-02 09:47:12
// author : creazyboyone
// note : 上来先暴搜一把，加上剪枝
// 得判断一下三元组是否相同，相同就不重复加入 [-1,0,1] [0,1,-1]
// 果然超时了
// 2023-05-02 看了下评论，提到双指针。是个不错的方法，试试
// 2023-06-20 突然间有个好方法，再试试。还是超时了。这只能算是双层循环+单指针。应该要单层循环+双指针才行
// 但如果是双指针的话，该如何走呢？i 固定了。变成一段长度数组，j开头k结尾，往中间走。为了不漏掉，j还是得循环，但k不必从end开始减！！
// 用flag记录下来，每次从上一次循环结束前的k开始减.还是超。j还是不能循环，不然还是超。
// 2023-08-27 还是去看题解了，看到了一个和上面一模一样的思路，但之前自己试时会漏不知为啥。先试试了
// 成功了，但为啥之前不行呢？想了下应该是当时不太确定到底是j++ 还是k--.
// sum > 0 时 应该正数多，应该 k--
// sum < 0 时，负数多，j++

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<vector<int>> threeSum(vector<int> &nums) {
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());
        int num = (int) nums.size();

        for (int i = 0; i < num; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = num - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    vector<int> arr = {nums[i], nums[j], nums[k]};
                    result.push_back(arr);
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return result;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
