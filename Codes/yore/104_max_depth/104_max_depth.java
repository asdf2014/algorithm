public int maxDepth(TreeNode root) {
    return getDepth(root);
}

public int getDepth(TreeNode root){
    if(root ==null){
        return 0;
    }
    return Math.max(getDepth(root.left)+1,getDepth(root.right)+1);
}