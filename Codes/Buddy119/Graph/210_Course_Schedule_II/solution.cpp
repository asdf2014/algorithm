class Solution {
public:
    vector<int> findOrder(int numCourses, vector<pair<int, int>>& prerequisites) {
        graph = vector<vector<int>>(numCourses);
        for(auto item : prerequisites){
            graph[item.second].push_back(item.first);
        }
        vector<int> answer;
        vector<int> v(numCourses, 0);
        
        for(int i = 0; i < numCourses; i++){
            if(dfs(i, v, answer)) return {};
        }
        reverse(begin(answer), end(answer));
        return answer;
    }
private:
    vector<vector<int>> graph;
    
    bool dfs(int cur, vector<int>& v, vector<int>& ans){
        if(v[cur] == 2) return false;
        if(v[cur] == 1) return true;
        
        v[cur] = 1;
        
        for(int i : graph[cur]){
            if(dfs(i, v, ans)) return true;
        }
        v[cur] = 2;
        ans.push_back(cur);
        
        return false;
    }
};
