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
    ListNode* getKthFromEnd(ListNode* head, int k) {
         ListNode* p;
        p = head;
        int count = 0;
        while(head != NULL) {
            head = head->next;
            if(count == k) {
                p = p->next;
            } else {
                ++count;
            }
        }
        return p;
    }
};