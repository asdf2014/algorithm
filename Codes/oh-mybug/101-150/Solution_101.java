/**
 * ClassName: Solution_101
 * Date:      2020/4/4 17:28
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
101. 对称二叉树
    给定一个二叉树，检查它是否是镜像对称的。
    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
            1
           / \
          2   2
         / \ / \
        3  4 4  3
    但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
            1
           / \
          2   2
           \   \
           3    3
    说明:
        如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class Solution_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return symmetric(root.left, root.right);
    }
    /**
     * 核心函数，递归判断是否镜像
     * 函数使用递归思想，把根节点以下两颗树当作两个'世界'，然后进行递归遍历所有的树节点
     *                  1
     *               / \
     *              2   2
     *            / \ / \
     *           3  4 4  3
     * 递归结束条件：
     *  ① 左右两棵树遍历到叶子结点（比如两棵树都遍历到了3） 返回true
     *                  1
     *               / \
     *              2   2
     *            / \ / \
     *           3  4 4  3
     *  ② 左右两颗树有一颗树遍历到叶子节点 而另一颗没有（比如一个有3 另一个没有） 返回false
     *                 1
     *               / \
     *              2   2
     *            / \ /
     *           3  4 4
     *  ③ 左右两棵树的对称结点值不相等（比如一个是3 一个是5） 返回false
     *                  1
     *               / \
     *              2   2
     *            / \ / \
     *           3  4 4  5
     * @Function TODO
     * @author   Oh_MyBug
     * @Date     2020/4/4 18:07
     * @param
     * @return
     */
    public boolean symmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        if (symmetric(leftNode.left, rightNode.right) == false) {
            return false;
        }
        if (symmetric(leftNode.right, rightNode.left) == false) {
            return false;
        }
        return true;
    }
}
