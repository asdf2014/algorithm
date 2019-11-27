class NumArray {
public:
	NumArray(vector<int> nums) {
		m_nums = nums;
		for(int i=1; i<nums.size(); ++i)
		{
			m_nums[i] += m_nums[i-1];
		}
	}

	int sumRange(int i, int j) {
		if(0==i)
			return m_nums[j];
		return m_nums[j]-m_nums[i-1];
	}
private:
	vector<int> m_nums;
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
