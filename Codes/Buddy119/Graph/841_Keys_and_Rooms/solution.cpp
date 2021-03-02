class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        if(rooms.empty()) return true;
        
        int y_edge = rooms.size();
        
        visited = vector<int>(y_edge, 0);
        dfs(rooms, 0);
        for(int i = 0; i < y_edge; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
private:
    int x_edge, y_edge;
    vector<int> visited;
    
    void dfs(vector<vector<int>>& rooms, int start){
        if(visited[start]) return;
        
        visited[start] = 1;
        for(auto neighbor : rooms[start]){
            if(visited[neighbor]) continue;
            dfs(rooms, neighbor);
        }
    }
};
