```python

class Solution:
    def mergeKLists(self, lists: list) -> ListNode:
        self.nodes = []
        head = point = ListNode(0)
        for i in lists:
            while i:
                self.nodes.append(i.val)
                i = i.next
        for i in sorted(self.nodes):
            point.next = ListNode(i)
            point = point.next
        return head.next

    def mergeKLists2(self, lists: list) -> ListNode:
        if len(lists) == 0: return

        def merge2Lists(l1, l2):
            if not l1: return l2
            if not l2: return l1
            if l1.val < l2.val:
                l1.next = merge2Lists(l1.next, l2)
                return l1
            else:
                l2.next = merge2Lists(l1, l2.next)
                return l2

        f1 = lists[0]
        for i in lists[1:]:
            f1 = merge2Lists(f1, i)
        return f1

    def mergeKLists3(self, lists: list) -> ListNode:
        if len(lists) < 1: return lists

        def merge2Lists(l1, l2):
            if not l1: return l2
            if not l2: return l1
            if l1.val < l2.val:
                l1.next = merge2Lists(l1.next, l2)
                return l1
            else:
                l2.next = merge2Lists(l1, l2.next)
                return l2

        size = len(lists)
        interval = 1
        while interval < size:
            for i in range(0, size - interval, interval * 2):
                lists[i] = merge2Lists(lists[i], lists[i + interval])
            interval *= 2

        return lists[0] if size > 0 else lists

    def mergeKLists4(self, lists: list) -> ListNode:
        from Queue import PriorityQueue

        q = PriorityQueue()
        head = point = ListNode(0)
        for i in lists:
            if i:
                q.put((i.val, i))

        while not q.empty():
            val, node = q.get()
            point.next = ListNode(val)
            point = point.next
            node = node.next
            if node:
                q.put((node.val, node))
        return head.next
```