class Solution {
public:
    bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
        graph = vector<vector<int>>(numCourses);
        for(auto item : prerequisites){
            graph[item.second].push_back(item.first);
        }
        vector<int> v(numCourses, 0);
        
        for(int i = 0; i < numCourses; i++){
            if(dfs(i, v)) return false;
        }
        return true;
    }
private:
    vector<vector<int>> graph;
    
    bool dfs(int cur, vector<int>& v){
        if(v[cur] == 2) return false;
        if(v[cur] == 1) return true;
        
        v[cur] = 1;
        for(int i : graph[cur]){
            if(dfs(i, v)) return true;
        }
        v[cur] = 2;
        return false;
    }
};
