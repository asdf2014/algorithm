// author: tango
// time: 2019.03.20
class Solution {
public:
    int reverse(int x) {
		int flag = 1;
		int ret = 0;
		if (x < 0) {	
			flag = 0;
			x = -x;
		}

		long long int before = 0;
		while (x) {
			before = ret;
			ret = ret * 10 + x%10;
			if (ret < 10*before)
			{
				ret = 0;
				break;
			}
			
			x = x/10;
		}
		if (flag==0)
			ret = -ret;
		return ret;
    }
};
