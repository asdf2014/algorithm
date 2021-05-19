int maxArea(vector<int>& height) {
	int max_area=0;
	int tmp_area=0;
	int min_height ;
	for(vector<int>::size_type st =0; st!=height.size(); ++st) {
		for(vector<int>::size_type sj=st+1; sj!=height.size(); ++sj) {
			min_height = height[st] > height[sj] ? height[sj] : height[st];
			tmp_area = min_height *(sj-st);
			max_area = max_area>tmp_area? max_area : tmp_area;
		}
	}
	return max_area;
}