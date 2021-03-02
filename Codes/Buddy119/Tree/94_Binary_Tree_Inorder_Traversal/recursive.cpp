/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        if(!root) return res;
        helper(root, res);
        return res;
    }
private:
    void helper(TreeNode* root, vector<int>& res){
        if(!root) return;
        helper(root->left, res);
        res.push_back(root->val);
        helper(root->right, res);
    }
};
