/**
 * ClassName:   com.ohmybug.Solution_99
 * Data:        2020/7/10
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
99. 恢复二叉搜索树
二叉搜索树中的两个节点被错误地交换。
请在不改变其结构的情况下，恢复这棵树。
示例 1:

输入: [1,3,null,null,2]

   1
  /
 3
  \
   2

输出: [3,1,null,null,2]

   3
  /
 1
  \
   2

示例 2:

输入: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

输出: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
 */
public class Solution_99 {
    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, true_tmp = null, tmp = null;

        TreeNode cur = root;                // 指定 cur 指针初始指向 root 节点
        while (cur != null) {               // 循环直到cur指针为NULL
            if (cur.left != null) {         // 当 cur 指针的左子节点不为 NULL 时
                // 找到 cur 指针的前序节点
                tmp = cur.left;
                while (tmp.right != null && tmp.right != cur)
                    tmp = tmp.right;

                if (tmp.right == null) {    // 当前序节点的右节点为 NULL 时
                    tmp.right = cur;        // 将其指向 cur
                    cur = cur.left;         // cur 指向 cur 的左节点
                }else {                     // 当前序节点的右节点不为 NULL时
                    // 检查是否需要交换
                    if (true_tmp != null && cur.val < true_tmp.val) {
                        y = cur;
                        if (x == null) x = true_tmp;
                    }
                    true_tmp = cur;

                    tmp.right = null;       // 将其置为 NULL
                    cur = cur.right;        // cur 指向 cur 的右节点
                }
            }else {                         // 当 cur 指针的左子节点为 NULL 时
                // 检查是否需要交换
                if (true_tmp != null && cur.val < true_tmp.val) {
                    y = cur;
                    if (x == null) x = true_tmp;
                }
                true_tmp = cur;

                cur = cur.right;            // cur 指针指向 cur 指针的右节点
            }
        }
        swap(x, y);
    }
}
