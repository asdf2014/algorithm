class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.empty()) return 0;
        y_edge = grid.size();
        x_edge = grid[0].size();
        int res = 0;
        for(int i = 0; i < y_edge; i++){
            for(int j = 0; j < x_edge; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, j, i);
                }
            }
        }
        return res;
    }
private:
    
    int x_edge;
    int y_edge;
    
    void dfs(vector<vector<char>>& grid, int x, int y){
        if(x < 0 || y < 0 || x >= x_edge || y >= y_edge || grid[y][x] == '0') return;
        
        grid[y][x] = '0';
        
        dfs(grid, x+1, y);
        dfs(grid, x-1, y);
        dfs(grid, x, y+1);
        dfs(grid, x, y-1);
    }
};
