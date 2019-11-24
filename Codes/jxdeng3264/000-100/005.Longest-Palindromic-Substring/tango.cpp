class Solution {
public:
    string longestPalindrome(string s) {
		if (0==s.length() || 1==s.length())
			return s;
		//考虑奇数
		string retstr;
		int ompos=0,omlen=1;
		int tomlen = 1;
		for (int idx=1; idx<s.length(); ++idx) {
			int flag=1;
			while(flag) {
				tomlen = omlen + 2;
				int leftcheck = tomlen/2;
				for(int i=1; i<=leftcheck; ++i) {
					if( idx-i >=0 && idx+i<s.length()) {
						if(s[idx-i]!=s[idx+i]) {
							flag = 0;
							break;
						}
					}
					else
						flag = 0;
				}

				if (flag) {
					ompos = idx;
					omlen = tomlen;
				}
			}//end while
		}//end for

		//cout<<"omlen:"<<omlen<<endl;
		//考虑偶数
		int empos =-1, emlen=0;
		int temlen = 0;
		for (int idx=0; idx<s.length(); ++idx) {
			int flag=1;
			while (flag) {
				temlen = emlen+2;
				//emlen += 2;
				int halfcheck = temlen/2;
				for (int i=1; i<=halfcheck; ++i) {
					if (idx-i+1>=0 && idx+i<s.length()) {
						if (s[idx-i+1]!=s[idx+i]) {
							flag = 0;
							break;
						}
					}
					else
						flag = 0;
				}//end for
				if (flag) {
					empos = idx;
					emlen = temlen;
				}
			}//end while

		}//end for

		// cout<<"偶数emlen:"<<emlen<<" empos:"<<empos<<"  omlen:"<<omlen<<" ompos:"<<ompos<<endl;
		if (emlen>omlen)
			retstr = s.substr(empos-emlen/2+1,emlen);
		else
			retstr = s.substr(ompos-omlen/2, omlen);

		return retstr;
	}
};
