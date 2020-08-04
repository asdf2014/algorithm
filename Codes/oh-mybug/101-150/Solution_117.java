/**
 * ClassName:   Solution_117
 * Data:        2020/8/5
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
117. 填充每个节点的下一个右侧节点指针 II
给定一个二叉树
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
 */
public class Solution_117 {
    public Node connect(Node root) {
        if (root == null) return null;
        helper(root);
        return root;
    }

    public void helper(Node root) {
        Node temp;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            System.out.println("left = " + root.left.val
                    + " right = " + root.right.val
                    + " root.next = " + (root.next == null ? "无" : root.next.val));
            temp = root;
            while (temp.next != null) {
                if (temp.next.left != null) {
                    root.right.next = temp.next.left;
                    break;
                }else if (temp.next.right != null) {
                    root.right.next = temp.next.right;
                    break;
                }
                temp = temp.next;
            }
            helper(root.left);
            helper(root.right);
            return;
        }

        if (root.left != null) {
            temp = root;
            while (temp.next != null) {
                if (temp.next.left != null) {
                    root.left.next = temp.next.left;
                    break;
                }else if (temp.next.right != null) {
                    root.left.next = temp.next.right;
                    break;
                }
                temp = temp.next;
            }
            helper(root.left);
        }

        if (root.right != null) {
            temp = root;
            while (temp.next != null) {
                if (temp.next.left != null) {
                    root.right.next = temp.next.left;
                    break;
                }else if (temp.next.right != null) {
                    root.right.next = temp.next.right;
                    break;
                }
                temp = temp.next;
            }
            helper(root.right);
        }
    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }
}
