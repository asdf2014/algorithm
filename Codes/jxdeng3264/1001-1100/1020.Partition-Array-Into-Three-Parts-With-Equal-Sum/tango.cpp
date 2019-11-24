#include <iostream>
#include <vector>
#include <iostream>

using namespace std;
class Solution {
public:
	bool canThreePartsEqualSum(vector<int>& A) {
		bool ret = false;
		int sum = 0;
		for (auto it:A)	
			sum += it;
		
		if (sum%3 != 0)	return false;

		int part_3 = sum / 3;
		
		//找到可能的 sum_part = part_3 的所有位置，然后遍历
		vector<int> pos_left;
		vector<int> pos_right;

		int t_sum = 0;
		for (int i = 0; i < A.size(); ++i)
		{
			t_sum += A[i];
			if (t_sum == part_3)
				pos_left.push_back(i);
		}

		t_sum = 0;
		for (int i = A.size() - 1; i >= 0; --i)
		{
			t_sum += A[i];
			if (t_sum == part_3)
				pos_right.push_back(i);
		}

		if (pos_left.size() == 0 || pos_right.size() == 0)	return false;

		int min_left = pos_left[0];
		for (int i = 0; i < pos_left.size(); ++i)	
			if (min_left > pos_left[i]) min_left = pos_left[i];

		int max_right = pos_right[0];
		for (int i = 0; i < pos_right.size(); ++i)
			if (max_right < pos_right[i])	max_right = pos_right[i];

		if (min_left + 1 < max_right)	 return true;

		return false;
			
    }
};

int main() {
	Solution s;
	vector<int> v{0,2,1,-6,6,-7,9,1,2,0,0};
	cout<<s.canThreePartsEqualSum(v)<<endl;

	return 0;
}
