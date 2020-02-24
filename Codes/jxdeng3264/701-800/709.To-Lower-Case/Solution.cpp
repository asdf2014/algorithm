class Solution {
public:
    string toLowerCase(string str) {
        for (int i=0; i<str.length(); ++i)
			str[i] |= 0x20;
		return str;
    }
};
