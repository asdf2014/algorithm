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
    bool hasPathSum(TreeNode* root, int sum) {
        if(!root) return false;
       return dfs(root, sum);
    }
private:
    bool dfs(TreeNode* root, int rest){
        if(!root) return false;
        if(root->val == rest && !root->left && !root->right) return true;
        return dfs(root->left, rest - root->val) || dfs(root->right, rest - root->val);
    }
};
