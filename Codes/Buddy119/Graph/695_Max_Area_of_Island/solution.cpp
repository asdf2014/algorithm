class Solution {
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        if(grid.empty()) return 0;
        y_edge = grid.size();
        x_edge = grid[0].size();
                
        int ans = 0;
        for(int i = 0; i < y_edge; i++){
            for(int j = 0; j < x_edge; j++){
                if(grid[i][j]){
                    int area = 0;
                    dfs(grid, j, i, area);
                    ans = max(ans, area);
                }
            }
        }
        return ans;
    }
private:
    int x_edge;
    int y_edge;
    
    void dfs(vector<vector<int>>& grid, int x, int y, int& area){
        if(x < 0 || y < 0 || x >= x_edge || y >= y_edge || grid[y][x] == 0) return;
        
        grid[y][x] = 0;
        area++;
        dfs(grid, x+1, y, area);
        dfs(grid, x-1, y, area);
        dfs(grid, x, y+1, area);
        dfs(grid, x, y-1, area);
    }
};
