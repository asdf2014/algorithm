/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// 思路：结果链表反向构建，高位在最后，遍历好l1,l2 之后得到结果链表，最后再反转
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *p = NULL;
        int len1 = 0;
        int len2 = 0;
        p = l1;
        while (p)  {
            len1++;
            p = p->next;
        }
        p = l2;
        while (p) {
            len2++;
            p = p->next;
        }

        int diff = 0;
        ListNode *p_short = NULL;
        if (len1 > len2)
        {
            diff = len1 - len2;
            p = l1;
            p_short = l2;
        }
        else 
        {
            diff = len2 - len1;
            p = l2;
            p_short = l1;
        }
        ListNode *res_head = NULL;
        while (diff--)
        {
            ListNode *t = new ListNode(p->val);
            t->next = res_head;
            res_head = t;
            p = p->next;
        }

        int carry = 0;
        while (p)
        {
            int s = p->val + p_short->val;
            ListNode *r = new ListNode(s%10);
            if (s>=10)
            {
                // res_head 有可能为空
                if(!res_head)
                {
                    res_head = new ListNode(1);
                }
                else 
                {
                    // 处理进位
                    ListNode *t = res_head;
                    ListNode *before = res_head->next;
                    int c = 1;
                    while (t && c)
                    {
                        before = t;
                        int tv = t->val + c;
                        t->val = tv%10;
                        c = tv/10;
                        t = t->next;
                    }
                    if (c)
                    {
                        ListNode *tt = new ListNode(1);
                        before->next = tt;
                    }
                }
            }

            r->next = res_head;
            res_head = r;

            p = p->next;
            p_short = p_short->next;
        }
        // cur = head;
        // 逆置
        ListNode t_head(0);
        while (res_head)
        {
            p = res_head->next;
            res_head->next = t_head.next;
            t_head.next =  res_head;
            res_head = p;
        }

        return t_head.next;
    }
};

/*
[7,2,4,3]
  [5,6,4]
*/