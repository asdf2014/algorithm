class Solution {
public:
    bool detectCapitalUse(string word) {
        int len = word.size();
        if(len == 0) {
            return true;
        }
        int count = 0;
        for(int i = 0; i < len; ++i) {
            if(isupper(word[i])) {
                ++count;
            }
        }
        if(count == 1 && isupper(word[0])) {
            return true;
        }
        if(count == len || count == 0) {
            return true;
        }
        return false;
    }
};