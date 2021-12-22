public boolean isSymmetric(TreeNode root) {
    return isSym(root, root);
}

public boolean isSym(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
        return true;
    }
    if (t1 == null || t2 == null) {
        return false;
    }
    return (t1.val == t2.val) && isSym(t1.left, t2.right) && isSym(t1.right, t2.left);
}