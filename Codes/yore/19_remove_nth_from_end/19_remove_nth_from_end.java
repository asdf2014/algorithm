public ListNode removeNthFromEnd(ListNode head, int n) {
	ListNode zero = new ListNode(0,head);
	ListNode first = head;
	ListNode second = zero;
	for (int i = 0; i < n; i++) {
		first = first.next;
	}
	while(first !=null){
		first = first.next;
		second = second.next;
	}
	second.next = second.next.next;
	return zero.next;
}