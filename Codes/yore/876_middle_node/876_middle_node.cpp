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
    ListNode* middleNode(ListNode* head) {
            int total =0;
			ListNode *p=head,*q=head;
			while(q!= NULL) {
				if((++total)%2 ==0) {
					p = p->next;
				}
				q= q->next;
			}
			return p;
    }
};