public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null) {
        return new ArrayList<>();
    }
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    TreeNode node = root;
    nodeQueue.offer(node);
    int count = 0;
    List<List<Integer>> result = new ArrayList<>();
    while (!nodeQueue.isEmpty()) {
        List<Integer> list = new ArrayList<>();
        count = nodeQueue.size();
        while (count > 0) {
            node = nodeQueue.poll();
            list.add(node.val);
            if (node.left != null) {
                nodeQueue.offer(node.left);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
            }
            count--;
        }
        result.add(list);
    }
    List<List<Integer>> res = new ArrayList<>(result.size());
    for (int i = result.size() - 1; i >= 0; i--) {
        res.add(result.get(i));
    }
    return res;
}