class Solution {
public:
	int numPairsDivisibleBy60(vector<int>& time) {
		map<int, int> m;
		for (int i = 0; i<time.size(); ++i) 
		{
			m[time[i]%60]++;
			time[i] %= 60;
		}
		int  cnt = 0;

		for (int i = 0 ; i <=30; ++i)
		{
			if (m.find(i) != m.end())
			{
				int n1 = m[i];
				int ii = (60-i)%60;// n1= 0 , n2=0;
				if (m.find(ii) != m.end())
				{
					int n2 = m[ii];
					cout<<n1<<" "<<n2<<endl;
					if (i != 0 && i != 30)
					{
						cnt += n1*n2;

					}
					else 
						cnt += (n1)*(n1-1)/2;
				}
			}
		}

		return cnt;
	}
};
