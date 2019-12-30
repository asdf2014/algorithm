#include <map>
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    	map<int,int> tempmap;
    	vector<int> result;
    	for (int i = 0; i<nums.size(); i++)
    	{
    		int t = nums[i];
    		if(tempmap.find(target-t)!=tempmap.end()){
    			result.push_back(tempmap[target-t]);
    			result.push_back(i);
    			return result;
    		}
    		tempmap[t] = i;
    	}
    	return result;
    }
};
