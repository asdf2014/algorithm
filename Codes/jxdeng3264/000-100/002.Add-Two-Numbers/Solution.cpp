//ID:2.Add Two Numbers
//Author:jxdeng3989
//Alg&Ds: linklist math
//Time:2018-10-20
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *res = NULL;
        ListNode *curnode = NULL;
        int carry = 0;
        int v1 = 0, v2 = 0;
        while( l1!=NULL || l2!=NULL)
        {
            if (l1!=NULL)
                v1 = l1->val;
            else
                v1 = 0;
            if (l2!=NULL)
                v2 = l2->val;
            else
                v2 = 0;

            ListNode *newnode = new ListNode((v1+v2+carry)%10);
            carry = (v1+v2+carry)/10;

            if(res==NULL)
                res = newnode;

            if(curnode==NULL)
                curnode = newnode;
            else
            {
                curnode->next = newnode;
                curnode = newnode;
            }
            if (l1!=NULL)
                l1 = l1->next;
            if(l2!=NULL)
                l2 = l2->next;
        }
        if( carry!=0)
        {
            ListNode *newnode = new ListNode(carry);
            curnode->next = newnode;
        }
        return res;
    }
};
