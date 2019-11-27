#include <iostream>
#include <vector>
using namespace std;

typedef struct ListNode{
	ListNode(int val)
	{
		_val = val;
		_next = NULL;
	} 

	int _val;
	ListNode *_next;
}ListNode;

ListNode *list_reverse(ListNode *head) {
	if (!head)	return head;

	ListNode *cur_head = NULL;
	ListNode *cur_handle = head;
	ListNode *tnext = cur_handle->_next;
	while (cur_handle) {
		cur_handle->_next = cur_head;
		cur_head = cur_handle;

		if (!tnext)	return cur_handle;

		cur_handle = tnext;
		tnext = tnext->_next;	
	}

	return NULL;
}

void show_list(ListNode *head)
{
	while (head)	cout<<head->_val<<" ", head = head->_next;
}


int main() {
	ListNode *v1 = new ListNode(1); 
	ListNode *v2 = new ListNode(2); 
	ListNode *v3 = new ListNode(3); 
	v1->_next = v2;
	v2->_next = v3;

	show_list(list_reverse(v1));
	return 0;
}
