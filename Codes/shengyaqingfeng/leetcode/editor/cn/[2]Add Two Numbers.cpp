//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics 链表 数学 
// 👍 5352 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        bool high = false;
        bool first = true;
        ListNode *node = new ListNode();
        ListNode *head = node;
        while (l1 != NULL || l2 != NULL)
        {
            if (!first)
            {
                ListNode *new_node = new ListNode();
                node->next = new_node;
                node = node->next;
            }
            first = false;
            if (l1 != NULL && l2 == NULL)
            {
                int a = l1->val;
                if (high)
                {
                    a++;
                    high = !high;
                }
                if (a <= 9)
                {
                    node->val = a;
                } else
                {
                    node->val = a - 10;
                    high = true;
                }
                l1 = l1->next;
            } else if (l1 == NULL)
            {
                int a = l2->val;
                if (high)
                {
                    a++;
                    high = !high;
                }
                if (a <= 9)
                {
                    node->val = a;
                } else
                {
                    node->val = a - 10;
                    high = true;
                }
                l2 = l2->next;
            } else
            {
                int a = l1->val + l2->val;
                if (high)
                {
                    a++;
                    high = !high;
                }
                if (a <= 9)
                {
                    node->val = a;
                } else
                {
                    node->val = a - 10;
                    high = true;
                }
                // 切换
                l1 = l1->next;
                l2 = l2->next;
            }
        }
        // 算完了，还有进位
        if (high)
        {
            ListNode *new_node = new ListNode();
            node->next = new_node;
            node = node->next;
            node->val = 1;
        }

        return head;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
