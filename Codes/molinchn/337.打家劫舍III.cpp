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
  int dfs(TreeNode* root, int& l, int& r) {
    if (root == nullptr) {
      return 0;
    }
    int ll = 0, rr = 0, lr = 0, rl = 0;
    l = dfs(root->left, ll, lr);
    r = dfs(root->right, rl, rr);
    return max(root->val + ll + lr + rl + rr, l + r);
  }
  int rob(TreeNode* root) {
    int l = 0, r = 0;
    return dfs(root, l, r);
  }
};