/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
//author:jxdeng3989@163.com
//
class Solution {
public:
    vector<double> averageOfLevels(TreeNode* root) {
                vector<double> resv;
		if (!root)
			return resv;
		
		queue<TreeNode *> tq1;
		queue<TreeNode *> tq2;
		queue<TreeNode *> *ptq1;
        queue<TreeNode *> *ptq2;
		tq1.push(root);
		ptq1 = &tq1;
		ptq2 = &tq2;
		resv.push_back(root->val);
		while (!ptq1->empty())
		{
			double sum = 0;
			int n = 0;
			TreeNode *tnode = NULL;
			while (!ptq1->empty())
			{
				tnode = ptq1->front();
				ptq1->pop();
				if (tnode->left)
				{
					sum += tnode->left->val;
					n++;
					ptq2->push(tnode->left);
				}
				
				if (tnode->right)
				{
					sum += tnode->right->val;
					n++;
					ptq2->push(tnode->right);
				}
			}
			if(n)
			    resv.push_back(sum/n); 
			queue<TreeNode*> *qtmp;
			qtmp = ptq1;
			ptq1 = ptq2;
			ptq2 = qtmp;
		}
		
		return resv;
    }
};
