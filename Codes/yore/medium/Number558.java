package com.yore.medium;

/**
 * @author Yore
 * @date 2022/7/15 9:17
 * @description
 */
public class Number558 {
    public Node intersect(Node quadTree1, Node quadTree2) {
        return helper(quadTree1, quadTree2);
    }

    public Node helper(Node q1, Node q2) {
        if (q1.isLeaf) {
            return q1.val ? q1 : q2;
        }
        if (q2.isLeaf) {
            return q2.val ? q2 : q1;
        }

        Node o1 = helper(q1.topLeft, q2.topLeft);
        Node o2 = helper(q1.topRight, q2.topRight);
        Node o3 = helper(q1.bottomLeft, q2.bottomLeft);
        Node o4 = helper(q1.bottomRight, q2.bottomRight);
        if (o1.isLeaf && o2.isLeaf && o3.isLeaf && o4.isLeaf && o1.val == o2.val && o1.val == o3.val && o1.val == o4.val) {
            return new Node(o1.val, true);
        }
        return new Node(false, false, o1, o2, o3, o4);
    }
}
