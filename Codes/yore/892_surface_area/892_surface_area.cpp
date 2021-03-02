class Solution {
public:
    int surfaceArea(vector<vector<int>>& grid) {
	      int surface = 0;
			int n = (int)grid.size();
			int tmp=0;
			for(vector<int>::size_type st1 = 0; st1!=grid.size(); ++st1) {
				for(vector<int>::size_type st2 = 0; st2!=grid[st1].size(); ++st2) {
					tmp = grid[st1][st2];
					if(tmp!=0) {
						surface += (6*tmp);
					}
					//减去上面遮挡面积
					if(tmp > 1) {
						surface -= (2 *(tmp-1));
					}
					//减去右边遮挡面积
					if((st2+1) <n && grid[st1][st2+1]>0 ) {
						surface -= min(tmp,grid[st1][st2+1]);
					}
					//减去前边遮挡面积
					if((st1+1) <n && grid[st1+1][st2]>0) {
						surface -= min(tmp,grid[st1+1][st2]);
					}
					//减去左边遮挡面积
					if(st1>=1 && grid[st1-1][st2]>0) {
						surface -= min(tmp,grid[st1-1][st2]);
					}
					//减去后边遮挡面积
					if(st2>=1 && grid[st1][st2-1]>0) {
						surface -= min(tmp,grid[st1][st2-1]);
					}
				}
			}
			return surface;
		}
};