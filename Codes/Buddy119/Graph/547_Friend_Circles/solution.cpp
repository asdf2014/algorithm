class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        if(M.empty()) return 0;
        x_edge = M[0].size();
        y_edge = M.size();
        visited = vector<int>(y_edge, 0);
        int ans = 0;
        for(int i = 0; i < y_edge; i++){
            if(visited[i]) continue;
            dfs(M, i);
            ans++;
        }
        return ans;
    }
private:
    int x_edge;
    int y_edge;
    vector<int> visited;
    
    void dfs(vector<vector<int>>& M, int start){
        if(visited[start]) return;
        
        visited[start] = 1;
        for(int i = 0; i < y_edge; i++){
            if(visited[i] || !M[start][i]) continue;
            dfs(M, i);
        }
    }
};
