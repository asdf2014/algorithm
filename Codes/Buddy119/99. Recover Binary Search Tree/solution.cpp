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
    void recoverTree(TreeNode* root) {
        inOrder(root);
        int tmp = first ->val;
        first ->val = second->val;
        second->val = tmp;
    }
private:
    TreeNode *pre = new TreeNode(INT_MIN);
    TreeNode *first = nullptr;
    TreeNode *second = nullptr;
    
    void inOrder(TreeNode* root){
        if(!root) return;
        inOrder(root->left);
        
        if(first == nullptr && pre->val > root->val) first = pre;
        if(first != nullptr && pre->val > root->val) second = root;
        
        pre = root;
        inOrder(root->right);
    }
};
