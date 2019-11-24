//ID:102
//Author:jxdeng3989
//Alg&Ds:stack, binary tree.

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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int> > resv;
		if (!root)
			return resv;

		queue<TreeNode *> tq1;
		queue<TreeNode *> tq2;
		queue<TreeNode *> *ptq1;
		queue<TreeNode *> *ptq2;
		tq1.push(root);
		ptq1 = &tq1;
		ptq2 = &tq2;
		vector<int> levelv;
		levelv.push_back(root->val);
		resv.push_back(levelv);
		while (!ptq1->empty())
		{
			levelv.clear();
			TreeNode *tnode = NULL;
			while (!ptq1->empty())
			{
				tnode = ptq1->front();
				ptq1->pop();
				if (tnode->left)
				{
					levelv.push_back(tnode->left->val);
					ptq2->push(tnode->left);
				}

				if (tnode->right)
				{
					levelv.push_back(tnode->right->val);
					ptq2->push(tnode->right);
				}
			}
			if (levelv.size())
				resv.push_back(levelv);
			queue<TreeNode*> *qtmp;
			qtmp = ptq1;
			ptq1 = ptq2;
			ptq2 = qtmp;
		}


		return resv;
    }
};
