/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> ans;
        postTree(root, ans);

        return ans;
        
    }

    void postTree(TreeNode* root, vector<int> &ans){
        if(root!=NULL){
            postTree(root->left, ans);
            postTree(root->right, ans);
            ans.push_back(root->val);

        }
    }
};
