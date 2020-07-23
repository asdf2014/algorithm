//Given an n-ary tree, return the preorder traversal of its nodes' values. 
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
//Output: [1,3,5,6,2,4]
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
//,12,null,13,null,null,14]
//Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
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
// 👍 593 👎 60


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

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> preorder(Node root) {
//        return recure(root);
        return iter(root);
    }

    private List<Integer> iter(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.push(root.children.get(i));
        }
        return list;
    }

    private List<Integer> recure(Node root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node n : root.children) {
            helper(n, res);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
