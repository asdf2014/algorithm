/**
 * ClassName: Solution_938
 * Date:      2020/4/21 20:32
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
938. 二叉搜索树的范围和
给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
二叉搜索树保证具有唯一的值。
示例 1：
    输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
    输出：32
示例 2：
    输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
    输出：23

提示：
    树中的结点数量最多为 10000 个。
    最终的答案保证小于 2^31。
 */
public class Solution_938 {
    int res;
    public int rangeSumBST(TreeNode root, int L, int R) {
        res = 0;
        helper(root, L, R);
        return res;
    }

    public void helper(TreeNode root, int L, int R) {
        if (root != null){
            if (L <= root.val && root.val <= R){
                res += root.val;
            }
            if (root.val < R){
                helper(root.right, L, R);
            }
            if (L < root.val){
                helper(root.left, L, R);
            }
        }
    }
}
