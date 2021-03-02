import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:   Solution_106
 * Data:        2020/8/4
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
例如，给出
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */
public class Solution_106 {
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(postorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode helper(int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right){
        if (postorder_left > postorder_right) return null;

        int inorder_root = indexMap.get(postorder[postorder_right]);

        TreeNode root = new TreeNode(postorder[postorder_right]);

        int size_left_subtree = inorder_root - inorder_left;

        root.left = helper(postorder, inorder_left, inorder_root - 1, postorder_left, postorder_left + size_left_subtree - 1);

        root.right = helper(postorder, inorder_root + 1, inorder_right, postorder_left + size_left_subtree, postorder_right - 1);

        return root;
    }
}
