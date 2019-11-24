#include <iostream>
#include <vector>
#include <iostream>
#include <cassert>

using namespace std;
class Solution {
public:
	int maxScoreSightseeingPair(vector<int>& A) {
		vector<int> v_ai_and_i(A.size());
		vector<int> v_aj_minus_j(A.size());

		int size = A.size();
		for (int i = 0; i < A.size(); ++i)	v_ai_and_i[i] = A[i] + i;
		for (int i = 0; i < A.size(); ++i)	v_aj_minus_j[i] = A[i] - i;

		int max = v_ai_and_i[0];
		for (int i = 1; i < size; ++i)	{
			if (max < v_ai_and_i[i])	max = v_ai_and_i[i];

			v_ai_and_i[i] = max;
		}

		max = v_aj_minus_j[size-1];
		for (int i = size-2; i >= 0; --i)	{
			if (max < v_aj_minus_j[i])	max = v_aj_minus_j[i];

			v_aj_minus_j[i] = max;
		}

#if 0
		for (int i = 0; i < size; ++i)
			cout<<" "<<v_ai_and_i[i];
		cout<<endl;
		for (int i = 0; i < size; ++i)
			cout<<" "<<v_aj_minus_j[i];
		cout<<endl;
#endif

		int sum = 0;
		for (int i = 0; i < size-1; ++i) {
			if (sum < v_ai_and_i[i] + v_aj_minus_j[i+1])	
				sum = v_ai_and_i[i] + v_aj_minus_j[i+1];

			//sum = v_ai_and_i[i] + v_aj_minus_j[i];
		}

		return sum;
    }

};
int main() {
	Solution s;
	vector<int> v{8,1,5,2,6};
	cout<<s.maxScoreSightseeingPair(v) <<endl;
	assert(s.maxScoreSightseeingPair(v) == 11);
	return 0;
}
