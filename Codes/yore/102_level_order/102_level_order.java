public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
        return new ArrayList<>();
    }
    Queue<TreeNode> st = new LinkedList<>();
    TreeNode node = root;
    st.offer(node);
    int count = 0;
    List<List<Integer>> result = new ArrayList<>();
    while (!st.isEmpty()) {
        List<Integer> list = new ArrayList<>();
        count = st.size();
        while (count > 0) {
            node = st.poll();
            list.add(node.val);
            if (node.left != null) {
                st.offer(node.left);
            }
            if (node.right != null) {
                st.offer(node.right);
            }
            count--;
        }
        result.add(list);
    }
    return result;
}