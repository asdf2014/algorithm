#include <iostream>
#include <vector>
#include <iostream>
#include <cassert>

using namespace std;
class Solution {
public:
	int smallestRepunitDivByK(int K) {
		long long int cur_val = 1;
		int cur_len = 1;

		while (cur_val % K != 0)
		{
			cout<<cur_val<<endl;
			//cur_val = cur_val * 10 + 1;
			cur_val = (cur_val%K)*10 + 1;
			cur_len++;
			if (cur_val > 2147483647)	return -1;
		}

		return cur_len; 
    }

};
int main() {
	Solution s;
	assert(s.smallestRepunitDivByK(1)==1);
	assert(s.smallestRepunitDivByK(2)==-1);
	assert(s.smallestRepunitDivByK(3)==3);
	return 0;
}
