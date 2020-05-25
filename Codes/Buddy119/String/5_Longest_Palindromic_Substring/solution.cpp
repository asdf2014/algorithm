class Solution {
public:
    string longestPalindrome(string s) {
        for(int i = 0; i < s.size(); i++){
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return s.substr(start, best_len);
    }
private:
    int start = 0;
    int best_len = 0;
    
    void helper(string s, int l, int r){
        while(i >= 0 && r < s.size() && s[l] == s[r]){
            l--;
            r++;
            
            if(r - l - 1 > best_len){
                start = l + 1;
                best_len = r -l - 1;
            }
            
        }
    }
    
}; 
