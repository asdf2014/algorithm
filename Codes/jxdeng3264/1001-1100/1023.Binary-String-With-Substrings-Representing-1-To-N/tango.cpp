#include <iostream>
#include <vector>
#include <iostream>
#include <cassert>
#include <set>

using namespace std;
class Solution {
public:
bool queryString(string S, int N) {
	set<int> s;
	int len = S.length();
	for (int i = 1; i <= len; ++i) {
		for (int j = 0; j <= len-i; ++j)// 起始位置
		{
			int sum = 0;
			for (int k = 0; k < i; ++k)
			{
				sum *= 2;
				sum += S[j+k] - '0';	
			}
			s.insert(sum);
		}
	}		

	for (int i = 1; i <= N; ++i)
	{
		if (s.find(i)==s.end())	return false;
	}

	return true;
}
};
int main() {
	Solution s;
	assert(s.queryString("0110", 3)==true);
	assert(s.queryString("0110", 4)==false);

	return 0;
}
