class Solution {
public:
    string reverseVowels(string s) {
        if(s.empty()) {
            return "";
        }
        set<char> char_set = {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'};
        int len = s.size();
        string reverse_str("");
        char a[len];
        int count = -1;
        for(int i = len - 1; i >= 0; --i) {
            if(char_set.count(s[i])) {
                a[++count] = s[i];
            }
        }
        int j = -1;
        for(int i = 0; i < len; ++i) {
            if(char_set.count(s[i])) {
                reverse_str += a[++j];
            } else {
                reverse_str += s[i];
            }
        }
        return reverse_str;
    }
};