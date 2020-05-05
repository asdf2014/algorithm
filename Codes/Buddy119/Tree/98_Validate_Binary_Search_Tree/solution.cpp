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
    bool isValidBST(TreeNode* root) {
        return inOrder(root);
    }
private:
    TreeNode *pre = nullptr;
    
    bool inOrder(TreeNode* root){
        if(!root) return true;
        if(!inOrder(root->left)) return false;
        
        if(pre && pre->val >= root->val) return false;
        pre = root;
        
        return inOrder(root->right);
    }
};
