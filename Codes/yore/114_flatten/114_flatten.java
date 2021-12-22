public void flatten(TreeNode root) {
	if (root == null) {
		return;
	}
	flatten(root.left);
	flatten(root.right);
	TreeNode right = root.right;
	TreeNode left = root.left;
	root.left = null;
	root.right = left;

	TreeNode p = root;
	while (p.right != null) {
		p = p.right;
	}
	p.right = right;
}