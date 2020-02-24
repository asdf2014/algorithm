class Solution {
public:
    string convertToBase7(int num) {
        if (num==0)
            return "0";
        string r;
		int n = num;
        while (num!=0)
        {
            int t = num%7;
            if (t<0)
                t = -t;
            r.push_back(t+'0');
            num /= 7;
        }
		
		if (n<0)
			r.push_back('-');
		for (int i=0; i<r.length()/2; ++i)
			std::swap(r[i], r[r.length()-1-i]);
		return r;
    }
};
