int preIndex;
int[] inOrder;
int[] preOrder;
Map<Integer, Integer> idxMap = new HashMap<>();

public TreeNode buildTree(int[] preorder, int[] inorder) {
	this.inOrder = inorder;
	this.preOrder = preorder;
	preIndex = 0;
	int idx = 0;
	for (Integer val : inOrder) {
		idxMap.put(val, idx++);
	}
	return createTree(0, inOrder.length - 1);
}

public TreeNode createTree(int inLeft, int inRight) {
	if (inLeft > inRight) {
		return null;
	}
	int rootVal = preOrder[preIndex];
	TreeNode node = new TreeNode(rootVal);
	int index = idxMap.get(rootVal);
	preIndex++;
	node.left = createTree(inLeft, index - 1);
	node.right = createTree(index + 1, inRight);
	return node;
}