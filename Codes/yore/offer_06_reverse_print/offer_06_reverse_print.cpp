/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> reversePrint(ListNode* head) {
         stack<int> st;
        vector<int> res;
        while(head != NULL) {
            st.push(head->val);
            head = head->next;
        }
        while(!st.empty()) {
            res.push_back(st.top());
            st.pop();
        }
        return res;
    }
};