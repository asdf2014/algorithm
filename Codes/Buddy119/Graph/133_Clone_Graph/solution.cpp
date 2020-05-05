/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;

    Node() {}

    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
public:
    Node* cloneGraph(Node* node) {
        if(!node) return nullptr;
        
        if(dic.find(node) == dic.end()){
            dic[node] = new Node(node->val, {});
            for(auto neighbor : node->neighbors){
                dic[node]->neighbors.push_back(cloneGraph(neighbor));
            }
        }
        return dic[node];
    }
private:
    unordered_map<Node*, Node*> dic;
};
