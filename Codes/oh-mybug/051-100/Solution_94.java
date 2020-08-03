import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: com.ohmybug.Solution_94
 * Date:      2020/4/16 11:34
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
94. 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历。
示例:
    输入: [1,null,2,3]
       1
        \
         2
        /
       3

    输出: [1,3,2]
 */
public class Solution_94 {

    public static void main(String[] args) {

    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        // 方法一：递归
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    // 方法一：递归
    //第一种解决方法是使用递归。这是经典的方法，直截了当。我们可以定义一个辅助函数来实现递归。
    public static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}