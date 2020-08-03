import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void generateTree(Integer[] values){
        Queue<TreeNode> queue = new LinkedList<>();
        root = new TreeNode(values[0]);
        queue.offer(root);

        TreeNode curNode = null;
        TreeNode left = null;
        TreeNode right = null;
        boolean isLeft = false;
        for (int i = 1; i < values.length; i++) {
            isLeft = !isLeft;
            curNode = queue.element();
            if (!isLeft)
                queue.poll();
            if (values[i] == null)    continue;
            if (isLeft) {
                left = new TreeNode(values[i]);
                queue.offer(left);
                curNode.setLeft(left);
            }else {
                right = new TreeNode(values[i]);
                queue.offer(right);
                curNode.setRight(right);
            }
        }
    }

    public void PreOrder(TreeNode root){
        System.out.println(root.getVal());
        if (root.getLeft() != null)
            PreOrder(root.getLeft());
        if (root.getRight() != null)
            PreOrder(root.getRight());
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "com.ohmybug.fifty_2.TreeNode{" +
                "val=" + val +
                '}';
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
