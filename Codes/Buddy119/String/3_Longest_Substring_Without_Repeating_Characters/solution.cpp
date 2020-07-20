class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.empty()) return 0;
        vector<int> visited(128, -1);
        int res = 0;
        int start = 0;
        for(int i = 0; i < s.size(); i++){
            if(visited[s[i]] != -1){
                start = max(start, visited[s[i]] + 1);
            }
            visited[s[i]] = i;                 
            res = max(res, i - start + 1);
        }
        return res;
    }
};
