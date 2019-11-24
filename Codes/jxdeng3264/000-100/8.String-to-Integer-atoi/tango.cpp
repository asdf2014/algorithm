class Solution {
public:
    int myAtoi(string str) {
        //delete space 
		int ret =0;
		string tmpstr;
		string::iterator it = str.begin();
		bool hascharbef = false;
		//删除前导空格
		while( it!=str.end()) {
			if (*it!=' ')
				hascharbef = true;
				
			if(*it==' ' && hascharbef==true )
				tmpstr.push_back(*it);
			else if(*it!=' ')
				tmpstr.push_back(*it);
			++it;
		}
		//判断正负数
		if(tmpstr.length()==0)
			return 0;
		//
		if(tmpstr[0]!='-' && tmpstr[0]!='+' && (tmpstr[0]>'9' || tmpstr[0]<'0'))
			return 0;
		bool isNeg = false;
		int sp = 0;
		if (tmpstr[0] == '-') {
			isNeg = true;
			sp = 1;
		}
		if (tmpstr[0]=='+')
			sp = 1;
		
		//删除后续字符
		int tmpstrlen = tmpstr.length();
		int flagpos = tmpstrlen;
		for (int i = sp; i < tmpstrlen; ++i) {
			if (tmpstr[i]>'9' || tmpstr[i]<'0') {
				flagpos = i;
				break;
			}
		}

		string tmpstr2;
		for (int i = sp; i < flagpos; ++i)
		{ 
			tmpstr2.push_back(tmpstr[i]);
		}
		long long tmpnum = 0;
		sp = 0;
		while (sp != tmpstr2.length()) {
			tmpnum = tmpnum*10 + tmpstr2[sp]-'0';
			++sp;
			if(isNeg && tmpnum >= 2147483648)
				return -2147483648;
			else if (tmpnum >2147483647)
				return 2147483647;
		}
		//transform
		if (isNeg)
			tmpnum = -tmpnum;
		ret = (int)tmpnum;
		return ret;
    }
};
