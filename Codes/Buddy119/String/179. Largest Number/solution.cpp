class Solution {
public:
    string largestNumber(vector<int>& nums) {
        vector<string> tmp;
        for(auto num : nums){
            tmp.push_back(to_string(num));
        }
        sort(tmp.begin(), tmp.end(), [](string s1, string s2){return s1+s2 > s2+s1;});
        string res;
        for(auto s : tmp){
            res += s;
        }
        while(res[0] == '0' && res.size() > 1){
            res.erase(0, 1);
        }
        return res;
    }
};
