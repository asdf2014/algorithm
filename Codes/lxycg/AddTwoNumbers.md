- Problem Link: [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
- Language: C++

**Solution 1**:

```c++
// Runtime: 24ms
// Memory: 10.4MB
// 相当于做一次二路归并
// 注意一些边界条件: 比如5+5时最后的进位不要忘
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
        
        if (!l1 && !l2) return NULL;
        ListNode* h = new ListNode(0);
        
        int carry = 0;
        ListNode* tail = h;
        
        while (l1 && l2) {
            int sum = l1->val + l2->val + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            
            ListNode* node = new ListNode(remainder);
            tail->next = node;
            tail = tail->next;
            
            l1 = l1->next;
            l2 = l2->next;
        }
        
        
        while (l1) {
            int sum = l1->val + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            
            ListNode* node = new ListNode(remainder);
            tail->next = node;
            tail = tail->next;
            
            l1 = l1->next;
        }
        
        while (l2) {
            int sum = l2->val + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            
            ListNode* node = new ListNode(remainder);
            tail->next = node;
            tail = tail->next;
            
            l2 = l2->next;
        }
        
        if (carry != 0) {// 注意这里
            ListNode* node = new ListNode(carry);
            tail->next = node;
        }
        
        return h->next;
    }
};
```