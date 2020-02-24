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
		TreeNode* bstFromPreorder(vector<int>& preorder) {
			if (preorder.size()==0) return NULL;

			return createBstTree(preorder, 0, preorder.size()-1);
		}

		TreeNode *createBstTree(vector<int> &preorder, int prestart, int preend)
		{
			if (prestart < 0) return NULL;

			int rootvalue = preorder[prestart];
			TreeNode *root = new TreeNode(rootvalue);

			int rightpos = -1;
			for (int i = prestart; i <= preend; ++i)
			{
				if (preorder[i] > rootvalue)
				{
					rightpos = i;
					break;
				}
			}
			int leftpos = -1;
			for (int i = prestart; i <= preend; ++i)
			{
				if (preorder[i] < rootvalue)
				{
					leftpos = i;
					break;
				}
			}

			TreeNode *right = createBstTree(preorder, rightpos, preend);
			TreeNode *left = NULL;
			if (leftpos != -1 && rightpos!=-1) 
				left =  createBstTree(preorder, leftpos, rightpos-1);
			else if (leftpos!=-1 && rightpos==-1)
			{
				left = createBstTree(preorder, leftpos, preend);
			}

			root->left = left;
			root->right = right;
			return root;
		}
};
