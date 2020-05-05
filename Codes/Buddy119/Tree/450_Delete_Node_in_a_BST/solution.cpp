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
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(!root) return nullptr;
        else if(key > root->val){
            root->right = deleteNode(root->right, key);
        }
        else if(key < root->val){
            root->left = deleteNode(root->left, key);
        }
        else{
            if(!root->right && !root->left){
                delete root;
                root = nullptr;
            }
            else if(!root->right && root->left){
                TreeNode* tmp = root;
                root = root->left;
                delete tmp;
                tmp = nullptr;
            }
            else if(root->right && !root->left){
                TreeNode* tmp = root;
                root = root->right;
                delete tmp;
                tmp = nullptr;
            }
            else{
                int max = findMax(root->right);
                root->val = max;
                root->right = deleteNode(root->right, max);
            }
        }
        return root;
    }
private:
    int findMax(TreeNode* root){
        while(root->left){
            root = root->left;
        }
        return root->val;
    }
};
