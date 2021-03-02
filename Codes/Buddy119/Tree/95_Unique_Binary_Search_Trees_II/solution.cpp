class Solution {
public:
    vector<TreeNode*> generateTrees(int n) {
       if(n == 0) return {};
        return getAns(1, n);
    }
private:
    vector<TreeNode*> getAns(int l, int h){
        if(l > h) return {nullptr};
        vector<TreeNode*> ans;        
        for(int i = l; i <= h; i++){
            for(auto left : getAns(l, i-1)){
                for(auto right : getAns(i+1, h)){
                    TreeNode* root = new TreeNode(i);
                    root->left = left;
                    root->right = right;
                    ans.push_back(root);
                }
            }
        }
        return ans;
    }
};
