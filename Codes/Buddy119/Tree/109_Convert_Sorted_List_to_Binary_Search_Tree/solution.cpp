/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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
    TreeNode* sortedListToBST(ListNode* head) {
        vector<int> list;
        while(head){
            list.push_back(head->val);
            head = head->next;
        }
        int size = list.size();
        return help(list, 0, size-1);
    }
private:
    TreeNode* help(vector<int> list, int start, int end){
        if(start > end) return nullptr;
        int mid = start + (end - start)/2;
        TreeNode *root = new TreeNode(list[mid]);
        root->left = help(list, start, mid-1);
        root->right = help(list, mid+1, end);
        return root;
    }
};
