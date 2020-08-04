import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_114
 * Data:        2020/8/5
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
114. 二叉树展开为链表
给定一个二叉树，原地将它展开为一个单链表。
例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class Solution_114 {
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> nums = new ArrayList<>();
        helper1(root, nums);
        int len = nums.size();
        for (int i = 1; i < len; i++) {
            TreeNode prev = nums.get(i - 1), curr = nums.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void helper1(TreeNode root, List<TreeNode> nums) {
        if (root != null) {
            nums.add(root);
            helper1(root.left, nums);
            helper1(root.right, nums);
        }
    }
}
