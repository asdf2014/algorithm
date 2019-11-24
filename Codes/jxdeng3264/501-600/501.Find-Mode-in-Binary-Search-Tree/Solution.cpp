//Author:jxdeng3989@163.com
//ID:501
class Solution {
public:
    vector<int> findMode(TreeNode* root) {
        vector<int> res;
		map<int,int> m;
        if (root == NULL)   return res;
		stack<TreeNode *> s;
		TreeNode* curr = root;
		while (curr != NULL || !s.empty()){
			while (curr){
				s.push(curr);
				curr = curr->left;
			}
			curr = s.top();
			s.pop();
			m[curr->val]++;
			curr = curr->right;
		}
		
        int mm = 0;
		for (map<int,int>::iterator it = m.begin(); it != m.end(); ++it)
		{
			mm = std::max(mm, it->second);
		}
		
		for (map<int,int>::iterator it = m.begin(); it != m.end(); ++it)
		{
			if (it->second == mm)
				res.push_back(it->first);
		}
		
		return res;
    }
};
