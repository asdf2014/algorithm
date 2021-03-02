class Solution {
public:
    int findLUSlength(string a, string b) {
        if(a== b) {
            return -1;
        }
        int alen = a.size();
        int blen = b.size();
        return max(alen, blen);
    }
};