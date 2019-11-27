class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        vector<int> tvec;
        
        tvec.resize(nums.size()+1);
        
        for(vector<int>::iterator it=nums.begin(); it!=nums.end(); ++it)
        {
            tvec[*it]++;    
        }
        
        vector<int> ret;
        for (int i=1; i<tvec.size(); ++i)
        {
            if (2 == tvec[i])
            {
                ret.push_back(i);
            }
        }
        
        return ret;
    }
};
