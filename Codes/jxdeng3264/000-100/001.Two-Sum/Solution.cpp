//ID:001.Two Sum
//Author:jxdeng3264@163.com
//Alg&Ds:Binary Search
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> t = nums;
        sort(nums.begin(), nums.end());

        vector<int> res;
        for (int i=0; i<nums.size()-1; ++i)
        {
            int sp = i+1;
            int ep = nums.size()-1;
            while (sp<=ep)
            {
                int mid =(sp+ep)/2;
                if (nums[mid]+nums[i]==target)
                {
                    res.push_back(nums[mid]);
                    res.push_back(nums[i]);
                    break;
                }

                if (nums[mid]<target-nums[i])
                    sp = mid+1;
                else
                    ep = mid-1;
            }
        }

        for (int i=0; i<t.size(); ++i)
            if (t[i]==res[0])
            {
                res[0] = i;
                break;
            }

        for (int i=0; i<t.size(); ++i)
            if (t[i]==res[1] && i!=res[0])
            {
                res[1] = i;
                break;
            }
        return res;
    }
};
