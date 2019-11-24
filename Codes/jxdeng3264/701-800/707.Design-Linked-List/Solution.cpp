class MyLinkedList {
public:
    /** Initialize your data structure here. */
    MyLinkedList() {
    //    m_head = new ListNode(0);	
		m_size = 0;
		m_tail = &m_head;
		m_tail->next = NULL;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    int get(int index) {
        if (index >= m_size)
			return -1;
		int sp = -1;
		ListNode *p = &m_head;
		while (p)
		{
			p = p->next;
			sp++;
			if (sp==index)
				break;
		}
		return p->val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    void addAtHead(int val) {
		ListNode *n = new ListNode(val);
		n->next = m_head.next;
		m_head.next = n;
		m_size++;
		if (m_size==1)
			m_tail = m_head.next;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    void addAtTail(int val) {
        ListNode *n = new ListNode(val);
		m_tail->next = n;
		m_tail = n;
        m_size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    void addAtIndex(int index, int val) {
        if (index == m_size)
		{
			addAtTail(val);
		}
		else
		{
			int sp = -1;
			ListNode *p = &m_head;
			
			while (p)
			{
				sp++;
				if (sp == index)
				{
					ListNode *n = new ListNode(val);
					n->next = p->next;
					p->next = n;
					m_size++;
					return ;
				}
				p = p->next;
			}
		}
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    void deleteAtIndex(int index) {
        if (index >= m_size)
			return ;
		int sp = -1;	
		ListNode *p = &m_head;
		while (p)
		{
			sp++;
			if (sp==index)
			{
				ListNode *d = p->next;
				p->next = p->next->next;
				delete d;
				if (index == m_size-1)
				{
					m_tail = p;
				}
				m_size--;
			}
            p = p->next;
		}
    }
    
    typedef struct ListNode
	{
		int val;
		ListNode *next;
		ListNode():val(0), next(NULL){}
		ListNode(int v):val(v), next(NULL){}
	}ListNode;
	
	ListNode m_head;
	ListNode *m_tail;
	int m_size = 0;
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
