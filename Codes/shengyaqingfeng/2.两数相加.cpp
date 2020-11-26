/*
 * @lc app=leetcode.cn id=2 lang=cpp
 *
 * [2] 两数相加
 */
#include <iostream>
#include <vector>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
// @lc code=start
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
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        bool high = false;
        bool first = true;
        ListNode* node = new ListNode();
        ListNode* head = node;
        while (l1 != NULL || l2 != NULL)
        {
            if (!first)
            {
                ListNode* newnode = new ListNode();
                node->next = newnode;
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
                }
                else
                {
                    node->val = a - 10;
                    high = true;
                }
                l1 = l1->next;
            }
            else if (l1 == NULL && l2 != NULL)
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
                }
                else
                {
                    node->val = a - 10;
                    high = true;
                }
                l2 = l2->next;
            }
            else
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
                }
                else
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
            ListNode* newnode = new ListNode();
            node->next = newnode;
            node = node->next;
            node->val = 1;
        }
        
        return head;
    }
};
// @lc code=end

