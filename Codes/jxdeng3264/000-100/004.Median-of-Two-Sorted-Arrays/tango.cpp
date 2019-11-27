class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
		double median = 0;
		vector<int> merger;
		int len1 = nums1.size();
		int len2 = nums2.size();
		int i=0,j=0;
		while (i<len1 || j<len2)
		{
			while(i<len1 && j<len2)
			{
				if (nums1[i]<nums2[j])
				{
					merger.push_back(nums1[i]);
					i++;
				}
				else
				{
					merger.push_back(nums2[j]);
					j++;
				}
			}

			while(i<len1)
				merger.push_back(nums1[i++]);
			while(j<len2)
				merger.push_back(nums2[j++]);
		}

		if(merger.size()%2)
			median = merger[merger.size()/2]/1.0;
		else
			median = ( merger[(merger.size()-1)/2] + merger[merger.size()/2])/2.0;

		return median;
    }
};


