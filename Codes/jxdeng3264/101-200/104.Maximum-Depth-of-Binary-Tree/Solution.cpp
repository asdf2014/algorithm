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
		int maxDepth(TreeNode* root) {
			int depth = 0;
			if (!root)
				return depth;

			queue<TreeNode *> tq1;
			queue<TreeNode *> tq2;
			queue<TreeNode *> *ptq1;
			queue<TreeNode *> *ptq2;
			tq1.push(root);
			ptq1 = &tq1;
			ptq2 = &tq2;
			while (!ptq1->empty())
			{
				depth++;
				TreeNode *tnode = NULL;
				while (!ptq1->empty())
				{
					tnode = ptq1->front();
					ptq1->pop();
					if (tnode->left)
					{
						ptq2->push(tnode->left);
					}
					if (tnode->right)
					{
						ptq2->push(tnode->right);
					}
				}
				std::swap(ptq1, ptq2);
			}
			return depth;
		}
};
