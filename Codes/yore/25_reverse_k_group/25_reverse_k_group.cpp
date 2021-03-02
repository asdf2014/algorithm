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
    ListNode* reverseKGroup(ListNode* head, int k) {
        	if(k==1) {
				return head;
			}
			ListNode *gb,*ge,*lb,*le;
			ListNode *p,*q;
			ListNode *h=head,*r;
			int count = 0;
			bool flag = true;
			while(head!=NULL) {
				gb = head;
				while(head!=NULL) {
					if(++count == k) {
						break;
					}
					head = head->next;
				}
				if(count == k) {
					ge = head;
					head = head->next;
					lb= ge;
					le= gb;
					p = gb;
					q = gb->next;
					gb = q;
					while(gb != ge) {
						gb = q->next;
						q->next = p;
						p=q;
						q=gb;
					}
					q->next = p;
					if(flag) {
						h = lb;
						r = le;
						flag = false;
					} else {
						r->next = lb;
						r = le;
					}
                    le->next = NULL;
					count =0;
				}else{
					r->next = gb;
					break;
				}
			}
			return h;
    }
};