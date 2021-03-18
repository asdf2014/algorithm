#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Author  : Star
@Email   : zsdzzydos@gmail.com
@Time    : 2019年09月10日 15:36
@Desc    : 
"""


class Node:
    def __init__(self, val, next, random):
        self.val = val
        self.next = next
        self.random = random

    def __str__(self):
        n = self

        res = []
        while n:
            res.append(
                {
                    "val": n.val,
                    "next": n.next and n.next.val or None,
                    "random": n.random and n.random.val or None,
                }
            )
            n = n.next
        return str(res)


class Solution:
    def copyRandomList(self, head: "Node") -> "Node":
        """
        92 ms, 16 MB
        第一次做链表的题，由于不太直观打印链表的值，重写__str__的时候把其存在数组里
        突然想到可以用哈希来存储每一个链表的信息，然后更新，O(n)吧。。有点蛇皮的做法
        看别人都是各种花式操作，不太看得懂_(:зゝ∠)_

        后来看到排名第一的老哥的解法，哈哈竟然是一个原理，他的更精简
        相比之下我写的有点冗余了，他的不需要额外存储一个字典，而且没有items()操作：
        class Solution:
            def copyRandomList(self, head: 'Node') -> 'Node':
                hmap = {None: None}
                p = head
                while p:
                    hmap[p] = Node(p.val, None, None)
                    p = p.next

                p = head
                while p:
                    hmap[p].next = hmap[p.next]
                    hmap[p].random = hmap[p.random]
                    p = p.next

                return hmap[head]
        """
        if not head:
            return None
        hashMap = {}
        n = head
        while n:
            hashMap[n] = {
                "val": n.val,
                "next": n.next or None,
                "random": n.random or None,
                "newNode": Node(n.val, None, None),
            }
            n = n.next

        for n, v in hashMap.items():
            v["newNode"].next = hashMap[n.next]["newNode"] if n.next else None
            v["newNode"].random = hashMap[n.random]["newNode"] if n.random else None

        return hashMap[head]["newNode"]


if __name__ == "__main__":
    n2 = Node(2, None, None)
    n2.random = n2
    n1 = Node(1, n2, n2)
    print(n1)
    print(n2)
    s = Solution()
    print(s.copyRandomList(n1))
    print(s.copyRandomList(n2))

"""OFFICIAL TEST CASE
{
    "$id": "1",
    "next": {
                "$id": "2", 
                "next": null, 
                "random": {"$ref": "2"}, 
                "val": 2
            },
    "random": {"$ref": "2"}, 
    "val": 1
}
"""
