class Solution {
public:
    string replaceSpace(string s) {
        string replace;
        for(int i=0;i<s.size();i++){
            if(s[i]==' '){
                replace += "%20";
            }else{
                replace += s[i];
            }
        }
        return replace;
    }
};