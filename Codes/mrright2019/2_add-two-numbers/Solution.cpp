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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
		int px = 0;
		auto result = new ListNode(0);
		auto head = result;
		while (l1 != NULL || l2 != NULL) {
			int t1 = 0, t2 = 0,num=0;
			if (l1) {
				t1 = l1->val;
				l1 = l1->next;
			}
			if (l2) {
				t2 = l2->val;
				l2 = l2->next;
			}
			if(t1+t2+px>=10){
				num = t1+t2+px-10;
				px = 1;
			}else{
				num = t1+t2+px;
				px = 0;
			}
			result->next = new ListNode(num);
			result = result->next;
		}
		if(px==1){
			result->next = new ListNode(1);
		}
		return head->next;
	}
};
