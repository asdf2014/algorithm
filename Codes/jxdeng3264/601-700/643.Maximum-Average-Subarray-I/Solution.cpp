//author:jxdeng3989@163.com
//
class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        double res = 0;
        if (nums.size()<k)
            return res;
        for(int i=0; i<k; ++i)
            res += nums[i];
        int win = res;//滑动窗口
        for(int i=1; i<nums.size()-k+1; ++i)
        {
            win += nums[i+k-1]-nums[i-1];
            if (win>res)
                res = win;
        }
        return res/k;
    }
};
