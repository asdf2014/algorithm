//Given an n-ary tree, return the postorder traversal of its nodes' values. 
//
// Nary-Tree input serialization is represented in their level order traversal, 
//each group of children is separated by the null value (See examples). 
//
// 
//
// Follow up: 
//
// Recursive solution is trivial, could you do it iteratively? 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [5,6,3,2,4,1]
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
//,12,null,13,null,null,14]
//Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
// 
//
// 
// Constraints: 
//
// 
// The height of the n-ary tree is less than or equal to 1000 
// The total number of nodes is between [0, 10^4] 
// 
// Related Topics Tree 
// 👍 661 👎 64


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class ColorNode {
    int color;
    Node node;
    ColorNode (int color, Node node) {
        this.color = color;
        this.node = node;
    }
}


class Solution {
    public List<Integer> postorder(Node root) {
        return recure(root);
//        return iter(root);
//        return iter2(root);
    }

    private List<Integer> iter2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for(Node node: root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }

    private List<Integer> iter(Node root) {
        List<Integer> res = new LinkedList<>();
        Stack<ColorNode> stack = new Stack<>();
        int white = 1;
        int grey = 0;
        stack.push(new ColorNode(white, root));

        while (! stack.isEmpty()) {
            ColorNode cnode = stack.pop();
            if (cnode.node == null) continue;

            if (cnode.color == white) {
                for (Node n : cnode.node.children) {
                    stack.push(new ColorNode(white, n));
                }
                stack.push(new ColorNode(grey, cnode.node));
            } else res.add(cnode.node.val);
        }
        Collections.reverse(res);
        return res;
    }

    private List<Integer> recure(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) return;

        for (Node child : root.children) {
            helper(child, res);
        }
        res.add(root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
