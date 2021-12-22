public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode node = root;
    Stack<TreeNode> st = new Stack<>();
    while (!st.empty() || node != null) {
        while(node!=null){
            st.push(node);
            node = node.left;
        }
        node = st.pop();
        result.add(node.val);
        node = node.right;
    }
    return result;
}