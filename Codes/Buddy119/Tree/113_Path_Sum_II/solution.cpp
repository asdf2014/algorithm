/**
 * Definition for a binary tree node
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>> res;
        vector<int> ans;
        dfs(root, sum, res, ans);
        return res;
    }
private:
    void dfs(TreeNode* root, int sum, vector<vector<int>>& res, vector<int>& ans){
        if(!root) return;
        if(root->val == sum && !root->left && !root->right){
            ans.push_back(sum);
            res.push_back(ans);
            ans.pop_back();
            return;
        }
        ans.push_back(root->val);
        dfs(root->left, sum-root->val, res, ans);
        dfs(root->right, sum-root->val, res, ans);
        ans.pop_back();
    }
};
